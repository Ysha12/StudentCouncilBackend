import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddumpsComponent } from './addumps.component';

describe('AddumpsComponent', () => {
  let component: AddumpsComponent;
  let fixture: ComponentFixture<AddumpsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddumpsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddumpsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
