import { Age } from '../common/age';
import { Pincode } from '../common/pincode';
import { AgeService } from '../services/age.service';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { IDropdownSettings, MultiSelectComponent } from 'ng-multiselect-dropdown';
import { VaccineService } from '../services/vaccine.service';

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
  myForm!: FormGroup;
  public loadContent: boolean = false;
  regexNumberPattern = "^[0-9]*$";
  ageData = new Age('',-1,false);

  constructor(private fb: FormBuilder,
    private ageService: AgeService,
    private vaccineService: VaccineService) { }

  ngOnInit() {
    this.dropdownList = [];
    this.selectedItems = [];

    this.dropdownSettings = {
      singleSelection: false,
      idField: 'id',
      textField: 'age',
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
        console.log(response);
      }
    );
    
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
      dropdownList: new FormControl(this.dropdownList, Validators.required)
    });
    this.loadContent = true;
  }

  handleLimitSelection() {
    if (this.limitSelection) {
      this.dropdownSettings = Object.assign({}, this.dropdownSettings, { limitSelection: 2 });
    } else {
      this.dropdownSettings = Object.assign({}, this.dropdownSettings, { limitSelection: null });
    }
  }

  addNewOption(age: string) {
    this.ageData = new Age('',Number(age),true);
    this.ageService.createPincode(this.ageData).subscribe(
      response =>{
        console.log(response);
        setTimeout(() => {
          this.dropdownList = this.dropdownList.concat(this.ageData);
          this.ageData = new Age('',-1,false);
        }, 500);
      }
    )  
  }

}
