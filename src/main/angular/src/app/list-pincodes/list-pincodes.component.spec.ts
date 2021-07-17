import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListPincodesComponent } from './list-pincodes.component';

describe('ListPincodesComponent', () => {
  let component: ListPincodesComponent;
  let fixture: ComponentFixture<ListPincodesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListPincodesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListPincodesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
