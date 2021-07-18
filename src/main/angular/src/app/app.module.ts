import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VaccineslotComponent } from './vaccineslot/vaccineslot.component';
import { MenuComponent } from './menu/menu.component';
import { ListPincodesComponent } from './list-pincodes/list-pincodes.component';
import { PincodeComponent } from './pincode/pincode.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { PreferencesComponent } from './preferences/preferences.component';
import { CommonModule } from '@angular/common';
import { MultiselectComponent } from './multiselect/multiselect.component';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';

@NgModule({
  declarations: [
    AppComponent,
    VaccineslotComponent,
    MenuComponent,
    ListPincodesComponent,
    PincodeComponent,
    PreferencesComponent,
    MultiselectComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    ReactiveFormsModule,
    CommonModule,
    NgMultiSelectDropDownModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
