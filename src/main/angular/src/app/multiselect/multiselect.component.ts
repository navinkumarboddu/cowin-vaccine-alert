import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { IDropdownSettings, MultiSelectComponent } from 'ng-multiselect-dropdown';

@Component({
  selector: 'app-multiselect',
  templateUrl: './multiselect.component.html',
  styleUrls: ['./multiselect.component.css']
})
export class MultiselectComponent implements OnInit {
  @ViewChild('#multiSelect') 
  multiSelect!: any;
  disabled = false;
  ShowFilter = false;
  limitSelection = false;
  cities: City[] = [];
  selectedItems: City[] = [];
  dropdownSettings: any = {};

  dropdownList: City[] = [];
  myForm!: FormGroup;
  public loadContent: boolean = false;

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.dropdownList = [
      new City('1', 'Mumbai'),
      new City('2', 'Bangaluru'),
      new City('3', 'Pune'),
      new City('4', 'Navsari'),
      new City('5', 'New Delhi')
    ];
    this.selectedItems = [
      new City('1', 'Mumbai'),
      new City('4', 'Navsari')
    ];

    /*this.dropdownSettings = {
      singleSelection: false,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };*/

    this.dropdownSettings = {
      singleSelection: false,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
  };

    this.myForm = this.fb.group({
      city: [this.selectedItems]
    });
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

  addNewOption(name: string) {
    console.log('Hi Navin');
    setTimeout(() => {

      this.dropdownList = this.dropdownList.concat(new City('6','Joker'));

      console.log(this.dropdownList);
      //this.resetForm();
    }, 500);
  }

}

export class City {
  constructor(public item_id: String,
    public item_text: String) {

  }
}
