import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MunicipaldashComponent } from './municipaldash.component';

describe('MunicipaldashComponent', () => {
  let component: MunicipaldashComponent;
  let fixture: ComponentFixture<MunicipaldashComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MunicipaldashComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MunicipaldashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
