import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VaccineslotComponent } from './vaccineslot/vaccineslot.component';
import { MenuComponent } from './menu/menu.component';
import { ListPincodesComponent } from './list-pincodes/list-pincodes.component';
import { PincodeComponent } from './pincode/pincode.component';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    VaccineslotComponent,
    MenuComponent,
    ListPincodesComponent,
    PincodeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
