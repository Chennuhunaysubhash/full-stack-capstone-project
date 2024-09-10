import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorUpdateComponent } from './instructor-update.component';

describe('InstructorUpdateComponent', () => {
  let component: InstructorUpdateComponent;
  let fixture: ComponentFixture<InstructorUpdateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InstructorUpdateComponent]
    });
    fixture = TestBed.createComponent(InstructorUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
