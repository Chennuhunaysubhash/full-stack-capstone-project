import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorCourseUpdateComponent } from './instructor-course-update.component';

describe('InstructorCourseUpdateComponent', () => {
  let component: InstructorCourseUpdateComponent;
  let fixture: ComponentFixture<InstructorCourseUpdateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InstructorCourseUpdateComponent]
    });
    fixture = TestBed.createComponent(InstructorCourseUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
