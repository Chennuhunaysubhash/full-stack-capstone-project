import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { InstructorListComponent } from './instructor-list/instructor-list.component';
import { InstructorCreateComponent } from './instructor-create/instructor-create.component';
import { InstructorSerachComponent } from './instructor-serach/instructor-serach.component';
import { InstructorUpdateComponent } from './instructor-update/instructor-update.component';
import { InstructorDetailsComponent } from './instructor-details/instructor-details.component';
import { InstructorCourseComponent } from './instructor-course/instructor-course.component';
import { CourseListComponent } from './course-list/course-list.component';
import { InstructorCourseListComponent } from './instructor-course-list/instructor-course-list.component';
import { InstructorCourseUpdateComponent } from './instructor-course-update/instructor-course-update.component';

@NgModule({
  declarations: [
    AppComponent,
    InstructorListComponent,
    InstructorCreateComponent,
    InstructorSerachComponent,
    InstructorUpdateComponent,
    InstructorDetailsComponent,
    InstructorCourseComponent,
    CourseListComponent,
    InstructorCourseListComponent,
    InstructorCourseUpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
