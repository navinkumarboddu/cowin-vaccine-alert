import { TestBed } from '@angular/core/testing';

import { VaccineService } from './vaccine.service';

describe('VaccineService', () => {
  let service: VaccineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VaccineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
