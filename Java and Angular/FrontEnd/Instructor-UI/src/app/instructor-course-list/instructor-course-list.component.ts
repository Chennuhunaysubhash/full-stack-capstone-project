import { Component, OnInit } from '@angular/core';
import { Course } from '../course';
import { ActivatedRoute, Router } from '@angular/router';
import { InstructorService } from '../instructor.service';
import { CourseService } from '../course.service';
@Component({
  selector: 'app-instructor-course-list',
  templateUrl: './instructor-course-list.component.html',
  styleUrls: ['./instructor-course-list.component.css']
})
export class InstructorCourseListComponent implements OnInit {
  id!:number;
  course!:Course[];
  constructor(private route: ActivatedRoute, private instructorService:InstructorService,private courseService: CourseService,private router: Router){

  }
  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.instructorService.getCoruse(this.id).subscribe( data => {
      this.course = data;
    });
    
  }
  
  updateCourse(id: number){
    this.router.navigate(['instructor-course-update', id]);
  }
  deleteCourse(id:number){
    this.courseService.deleteCourse(id).subscribe( data => {
      this.navigetion();
      console.log(data);
    })
  }
  navigetion(){
    this.router.navigate(['instructor']);
  }
  backButton(){
    this.router.navigate(['instructor']);
  }
}
