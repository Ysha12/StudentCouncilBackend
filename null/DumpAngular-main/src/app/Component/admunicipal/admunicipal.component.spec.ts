import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmunicipalComponent } from './admunicipal.component';

describe('AdmunicipalComponent', () => {
  let component: AdmunicipalComponent;
  let fixture: ComponentFixture<AdmunicipalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdmunicipalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdmunicipalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
