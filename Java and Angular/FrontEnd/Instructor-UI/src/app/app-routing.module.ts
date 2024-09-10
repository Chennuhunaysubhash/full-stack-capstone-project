import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InstructorListComponent } from './instructor-list/instructor-list.component';
import { InstructorCreateComponent } from './instructor-create/instructor-create.component';
import { InstructorSerachComponent } from './instructor-serach/instructor-serach.component';
import { InstructorUpdateComponent } from './instructor-update/instructor-update.component';
import { InstructorDetailsComponent } from './instructor-details/instructor-details.component';
import { InstructorCourseComponent } from './instructor-course/instructor-course.component';
import { CourseListComponent } from './course-list/course-list.component';
import { InstructorCourseListComponent } from './instructor-course-list/instructor-course-list.component';
import { InstructorCourseUpdateComponent } from './instructor-course-update/instructor-course-update.component';
const routes: Routes = [
  {path: 'instructor', component: InstructorListComponent},
  {path: 'create-instructor', component:  InstructorCreateComponent},
  {path: 'search', component:  InstructorSerachComponent},
  {path: '', redirectTo: 'instructor', pathMatch: 'full'},
  {path: 'update-instructor/:id', component: InstructorUpdateComponent},
  {path: 'instructor-details/:id', component: InstructorDetailsComponent},
  {path: 'instructor-course-add/:id', component: InstructorCourseComponent},
  {path: 'course-list', component:  CourseListComponent},
  {path: 'instructor-course-list/:id', component:  InstructorCourseListComponent},
  {path: 'instructor-course-update/:id', component:  InstructorCourseUpdateComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
