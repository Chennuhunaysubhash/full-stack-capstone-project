import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorSerachComponent } from './instructor-serach.component';

describe('InstructorSerachComponent', () => {
  let component: InstructorSerachComponent;
  let fixture: ComponentFixture<InstructorSerachComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InstructorSerachComponent]
    });
    fixture = TestBed.createComponent(InstructorSerachComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
