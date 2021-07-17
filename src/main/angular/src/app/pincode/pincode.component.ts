import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Pincode } from '../common/pincode';
import { PincodeService } from '../services/pincode.service';

@Component({
  selector: 'app-pincode',
  templateUrl: './pincode.component.html',
  styleUrls: ['./pincode.component.css']
})
export class PincodeComponent implements OnInit {
  pincodeData!: Pincode;
  regexNumberPattern = "^[0-9]*$";
  
  constructor(private pincodeService: PincodeService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.pincodeData = new Pincode("","");
  }

  savePincode(){
    console.log(`Hi Pincode : ${this.pincodeData}`);
    this.pincodeService.createPincode(this.pincodeData).subscribe(
      response =>{
        console.log(response);
        this.router.navigate(["pincodes"]);
      }
    )   
  }
}
