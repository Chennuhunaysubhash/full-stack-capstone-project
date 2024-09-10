import { Component,OnInit } from '@angular/core';
import { Course } from '../course';
import { CourseService } from '../course.service';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-instructor-course-update',
  templateUrl: './instructor-course-update.component.html',
  styleUrls: ['./instructor-course-update.component.css']
})
export class InstructorCourseUpdateComponent implements OnInit 
{
  id!:number;
  course: Course = new Course();
  constructor(private courseService:CourseService,private route: ActivatedRoute,
    private router: Router){

  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.courseService.getCourseById(this.id).subscribe(data => {
      this.course = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.courseService.updateCourse(this.id, this.course).subscribe( data =>{
      this.goToCourseList();
    }
    , error => console.log(error));
  }
  goToCourseList(){
    this.router.navigate(['course-list']);
  }
  backButton(){
    this.router.navigate(['instructor']);
  }

}
