import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DumpsformComponent } from './dumpsform.component';

describe('DumpsformComponent', () => {
  let component: DumpsformComponent;
  let fixture: ComponentFixture<DumpsformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DumpsformComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DumpsformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
