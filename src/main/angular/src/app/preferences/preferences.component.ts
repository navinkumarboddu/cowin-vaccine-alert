import { Age } from '../common/age';
import { Pincode } from '../common/pincode';
import { AgeService } from '../services/age.service';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { IDropdownSettings, MultiSelectComponent } from 'ng-multiselect-dropdown';
import { VaccineService } from '../services/vaccine.service';
import { Vaccine } from '../common/vaccine';
import { Dose } from '../common/dose';
import { DoseService } from '../services/dose.service';
import { PreferenceService } from '../services/preference.service';

@Component({
  selector: 'app-preferences',
  templateUrl: './preferences.component.html',
  styleUrls: ['./preferences.component.css']
})
export class PreferencesComponent implements OnInit {
  @ViewChild('MySelectForm', { static: false })
  mySelectForm!: NgForm;
  public loadContent: boolean = false;
  isFormDisabled!: boolean;
  isDisabled: boolean = false;
  categories: any[] = [];
  selected: any[] = [];

  dropDownAges: Age[] = [];
  selectedAges: Age[] = [];
  ageData = new Age('',-1,false);

  dropDownVaccines: Vaccine[] = [];
  selectedVaccines: Vaccine[] = [];
  vaccineData = new Vaccine('','',false);

  dropDownDoses: Dose[] = [];
  selectedDoses: Dose[] = [];

  constructor(private ageService: AgeService,
    private vaccineService: VaccineService,
    private doseService: DoseService,
    private prefService: PreferenceService) { }

  ngOnInit(): void {
    this.ageService.retrieveAllAges().subscribe(
      response => {
        this.dropDownAges = response;
        console.log(response);
        for(let temp of response){
          if(temp.status === true){
            this.selectedAges.push(temp);
          }
        }
        this.dataLoadCheck();
    });

    this.vaccineService.retrieveAllVaccines().subscribe(
      response => {
        this.dropDownVaccines = response;
        for(let temp of response){
          if(temp.status){
            this.selectedVaccines.push(temp);
          }
        }
        this.dataLoadCheck();
    });

    this.doseService.retrieveAllDoses().subscribe(
      response => {
        this.dropDownDoses = response;
        for(let temp of response){
          if(temp.status){
            this.selectedDoses.push(temp);
          }
        }
        this.dataLoadCheck();
    });

    this.categories = [
      {id: 1, name: 'Laravel'},
      {id: 2, name: 'Codeigniter'},
      {id: 3, name: 'React'},
      {id: 4, name: 'PHP'},
      {id: 5, name: 'Angular'},
      {id: 6, name: 'Vue'},
      {id: 7, name: 'JQuery', disabled: true},
      {id: 8, name: 'Javascript'},
    ];
      
    this.selected = [
      {id: 5, name: 'Angular'},
      {id: 6, name: 'Vue'}
    ];
  }

  dataLoadCheck(){
    if(this.dropDownAges.length > 0 && this.dropDownVaccines.length > 0 && this.dropDownDoses.length > 0){
      this.loadContent = true;
    }
  }
  
  name = 'Angular';
  
  
   
  getSelectedValue(){
    console.log(this.selected);
  }

  onFormSubmit() {
    this.mySelectForm.form.markAllAsTouched();
    if (this.mySelectForm.form.invalid) {
      console.log('Please fill valid details!');
      return false;
    }
    console.log('Form Submitted!');
    return true;
  }

  addCustomUser = (term:any) => ({id: term, name: term});
  addAgeOption = (age: any) => {
    this.ageData = new Age('-1',Number(age),true);
    this.ageService.createAge(this.ageData).subscribe(
      response =>{
        console.log(response);
        setTimeout(() => {
          this.dropDownAges= this.dropDownAges.concat(response);
          this.ageData = new Age('',-1,false);
        }, 500);
      }
    );  
  };
  addVaccineOption = (vaccine: any) => {
    this.vaccineData = new Vaccine('-1',vaccine,true);
    this.vaccineService.createVaccine(this.vaccineData).subscribe(
      response =>{
        console.log(response);
        setTimeout(() => {
          this.dropDownVaccines = this.dropDownVaccines.concat(response);
          this.vaccineData = new Vaccine('','',false);
        }, 500);
      }
    );
  };

  savePref(){
    console.log(this.mySelectForm.form.value);
    this.prefService.createPreference(this.mySelectForm.form.value).subscribe(
      response =>{
        console.log(response);
      }
    );
  }
}