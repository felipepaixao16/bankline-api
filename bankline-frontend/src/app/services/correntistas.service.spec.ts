import { TestBed } from '@angular/core/testing';

import { CorrentistasService } from './correntistas.service';

describe('CorrentistasService', () => {
  let service: CorrentistasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CorrentistasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
