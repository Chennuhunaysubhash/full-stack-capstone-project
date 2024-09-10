import { Component,OnInit } from '@angular/core';
import { Course } from '../course';
import { CourseService } from '../course.service';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {

  course!: Course[]

  constructor(private courseService:CourseService,private router: Router,private route: ActivatedRoute){

  }


  ngOnInit(): void {
    this.getCourse();
  }

  private getCourse(){
    this.courseService.getCourseList().subscribe(data => {
      this.course = data;
    });
  }
  registerForm(){
    this.router.navigate(['search']);
  }

  backButton(){
    this.router.navigate(['instructor']);
  }

}
