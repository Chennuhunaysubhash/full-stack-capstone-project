import { Component, OnInit } from '@angular/core';
import { Course } from '../course';
import { InstructorService } from '../instructor.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-instructor-course',
  templateUrl: './instructor-course.component.html',
  styleUrls: ['./instructor-course.component.css']
})
export class InstructorCourseComponent implements OnInit {

  id!:number;
  course: Course = new Course();
  constructor(private instructorService:InstructorService,private route: ActivatedRoute,
    private router: Router){

  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

  }

  saveCourse(){
    this.instructorService.addCourse(this.id,this.course).subscribe( data =>{
      console.log(data);
      this.goToInstructorList();
    },
    error => console.log(error));
  }
  goToInstructorList(){
    this.router.navigate(['/course-list']);
  }

  onSubmit(){
    this.saveCourse();
    console.log(this.course);
  }
  backButton(){
    this.router.navigate(['/instructor']);
  }

}
