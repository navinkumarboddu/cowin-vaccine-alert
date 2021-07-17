import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VaccineslotComponent } from './vaccineslot.component';

describe('VaccineslotComponent', () => {
  let component: VaccineslotComponent;
  let fixture: ComponentFixture<VaccineslotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VaccineslotComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VaccineslotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
