import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorCourseListComponent } from './instructor-course-list.component';

describe('InstructorCourseListComponent', () => {
  let component: InstructorCourseListComponent;
  let fixture: ComponentFixture<InstructorCourseListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InstructorCourseListComponent]
    });
    fixture = TestBed.createComponent(InstructorCourseListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
