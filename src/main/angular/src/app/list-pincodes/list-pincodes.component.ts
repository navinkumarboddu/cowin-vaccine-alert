import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pincode } from '../common/pincode';
import { PincodeService } from '../services/pincode.service';

@Component({
  selector: 'app-list-pincodes',
  templateUrl: './list-pincodes.component.html',
  styleUrls: ['./list-pincodes.component.css']
})
export class ListPincodesComponent implements OnInit {

  pincodes: Pincode[] = [];
  pincodeMessage : String = "";

  constructor(
    private pincodeService: PincodeService,
    private router: Router) { }

  ngOnInit() {
    this.refreshPincodes();
  }

  refreshPincodes() {
    this.pincodeService.retrieveAllPincodes().subscribe(
      response => {
        console.log(response);
        if(response.length > 0){
          this.pincodes = response;
        } else {
          this.pincodeMessage = "No Pincodes are added !";
        }
      }
    )
  }

  addPincode(){
    this.router.navigate(['pincode']);
  }

  deletePincode(id: string){
    console.log(`deletedTodo : ${id}`);
    this.pincodeService.deletePincode(Number(id)).subscribe(
      response => {
        console.log(response);
        this.pincodeMessage = `Delete Success of ${id} Successful !`;
        this.refreshPincodes();
      }
    );
  }

}
