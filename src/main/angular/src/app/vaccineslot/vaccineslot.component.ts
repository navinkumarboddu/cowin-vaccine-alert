import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Sessions } from '../common/session';
import { VaccineService } from '../services/vaccine.service';
import { Observable, interval, Subscription } from 'rxjs';

@Component({
  selector: 'app-vaccineslot',
  templateUrl: './vaccineslot.component.html',
  styleUrls: ['./vaccineslot.component.css']
})
export class VaccineslotComponent implements OnInit {

  sessions: Sessions[] = [];
  constructor(private vaccineService: VaccineService,private modalService: NgbModal) { }
  @ViewChild('alertButton') myDiv!: ElementRef<HTMLElement>;
  private updateSubscription!: Subscription;

  ngOnInit(): void {
    this.vaccineService.retrieveAllSessions().subscribe(
      response => {
        this.sessions = response;
        if(this.sessions.length){
          let el: HTMLElement = this.myDiv.nativeElement;
          el.click();
          //this.open(this.modalContent);
        }
      }
    )

    this.updateSubscription = interval(20000).subscribe(
      (val) => { 
        this.vaccineService.retrieveAllSessions().subscribe(
          response => {
            this.sessions = response;
            if(this.sessions.length){
              let el: HTMLElement = this.myDiv.nativeElement;
              el.click();
              //this.open(this.modalContent);
            }
          }
        )
    });
  }

  closeResult!: string;
  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
    let audio: HTMLAudioElement = new Audio('/assets/sounds/toast_sound.mp3');
     audio.play();
  }
  
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

}
