import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MunicipalformComponent } from './municipalform.component';

describe('MunicipalformComponent', () => {
  let component: MunicipalformComponent;
  let fixture: ComponentFixture<MunicipalformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MunicipalformComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MunicipalformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
