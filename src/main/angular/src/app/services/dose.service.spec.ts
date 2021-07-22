import { TestBed } from '@angular/core/testing';

import { DoseService } from './dose.service';

describe('DoseService', () => {
  let service: DoseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DoseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
