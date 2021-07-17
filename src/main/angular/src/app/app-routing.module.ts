import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListPincodesComponent } from './list-pincodes/list-pincodes.component';
import { PincodeComponent } from './pincode/pincode.component';
import { VaccineslotComponent } from './vaccineslot/vaccineslot.component';

const routes: Routes = [
  {path:'', component: VaccineslotComponent},
  {path:'pincodes', component: ListPincodesComponent},
  {path:'pincode', component: PincodeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
