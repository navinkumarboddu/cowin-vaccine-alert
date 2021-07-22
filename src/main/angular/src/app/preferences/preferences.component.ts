import { Age } from '../common/age';
import { Pincode } from '../common/pincode';
import { AgeService } from '../services/age.service';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { IDropdownSettings, MultiSelectComponent } from 'ng-multiselect-dropdown';
import { VaccineService } from '../services/vaccine.service';
import { Vaccine } from '../common/vaccine';

@Component({
  selector: 'app-preferences',
  templateUrl: './preferences.component.html',
  styleUrls: ['./preferences.component.css']
})
export class PreferencesComponent implements OnInit {
  @ViewChild('#multiSelect') 
  multiSelect!: any;
  disabled = false;
  ShowFilter = false;
  limitSelection = false;
  ages: Age[] = [];
  selectedItems: Age[] = [];
  dropdownSettings: any = {};
  dropdownList: Age[] = [];
  ageData = new Age('',-1,false);

  vaccines: Vaccine[] = [];
  selectedVaccines: Vaccine[] = [];
  dropdownVaccineSettings: any = {};
  dropdownVaccineList: Vaccine[] = [];
  vaccineData = new Vaccine('','',false);

  myForm!: FormGroup;
  public loadContent: boolean = false;
  regexNumberPattern = "^[0-9]*$";
  

  constructor(private fb: FormBuilder,
    private ageService: AgeService,
    private vaccineService: VaccineService) { }

  ngOnInit() {
    this.dropdownList = [];
    this.selectedItems = [];
    this.selectedVaccines = [];

    this.dropdownSettings = {
      singleSelection: false,
      idField: 'id',
      textField: 'age',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };

    this.dropdownVaccineSettings = {
      singleSelection: false,
      idField: 'id',
      textField: 'vaccinename',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };
  
    this.ageService.retrieveAllAges().subscribe(
      response => {
        this.dropdownList = response;
        for(let temp of response){
          if(temp.status){
            this.selectedItems.push(temp);
          }
        }
        //console.log(this.selectedItems);
        this.myForm = this.fb.group({
          age: [this.selectedItems]
       });
    });
    
    this.vaccineService.retrieveAllVaccines().subscribe(
      response => {
        this.dropdownVaccineList = response;
        for(let temp of response){
          if(temp.status){
            console.log('Vaccine Response:' + temp.status);
            this.selectedVaccines.push(temp);
          }
        }
      //console.log(this.selectedVaccines);
      this.myForm = this.fb.group({
        vaccinename: [this.selectedVaccines]
     });
    });
    
    this.setForm();
  }

  public onFilterChange(item: any) {
    console.log(item);
  }
  onItemSelect(item: any) {
    console.log('onItemSelect', item);
  }
  onSelectAll(items: any) {
    console.log('onSelectAll', items);
  }
  toogleShowFilter() {
    this.ShowFilter = !this.ShowFilter;
    this.dropdownSettings = Object.assign({}, this.dropdownSettings, { allowSearchFilter: this.ShowFilter });
    this.dropdownVaccineSettings = Object.assign({}, this.dropdownVaccineSettings, { allowSearchFilter: this.ShowFilter });
  }

  public resetForm() {
    // beacuse i need select all crickter by default when i click on reset button.
    this.setForm();
    this.multiSelect.toggleSelectAll();
    // i try below variable isAllItemsSelected reference from your  repository but still not working
    // this.multiSelect.isAllItemsSelected = true;
  }

  public setForm() {
    this.myForm = new FormGroup({
      age: new FormControl(this.dropdownList, Validators.required),
      vaccinename: new FormControl(this.dropdownVaccineList, Validators.required)
    });
    this.loadContent = true;
  }

  handleLimitSelection() {
    if (this.limitSelection) {
      this.dropdownSettings = Object.assign({}, this.dropdownSettings, { limitSelection: 2 });
      this.dropdownVaccineSettings = Object.assign({}, this.dropdownVaccineSettings, { limitSelection: 2 });
    } else {
      this.dropdownSettings = Object.assign({}, this.dropdownSettings, { limitSelection: null });
      this.dropdownVaccineSettings = Object.assign({}, this.dropdownVaccineSettings, { limitSelection: null });
    }
  }

  addAgeOption(age: any) {
    console.log(age);
    this.ageData = new Age('',Number(age),true);
    this.ageService.createAge(this.ageData).subscribe(
      response =>{
        console.log(response);
        setTimeout(() => {
          this.dropdownList = this.dropdownList.concat(this.ageData);
          this.ageData = new Age('',-1,false);
        }, 500);
      }
    )  
  }

  addVaccineOption(vaccine: string) {
    this.vaccineData = new Vaccine('',vaccine,true);
    this.vaccineService.createVaccine(this.vaccineData).subscribe(
      response =>{
        console.log(response);
        setTimeout(() => {
          this.dropdownVaccineList = this.dropdownVaccineList.concat(this.vaccineData);
          this.vaccineData = new Vaccine('','',false);
        }, 500);
      }
    )  
  }

}