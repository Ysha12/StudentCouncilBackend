import { TestBed } from '@angular/core/testing';

import { MarkerService } from 'src/app/Services/Maker/marker.service';

describe('MarkerService', () => {
  let service: MarkerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MarkerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
