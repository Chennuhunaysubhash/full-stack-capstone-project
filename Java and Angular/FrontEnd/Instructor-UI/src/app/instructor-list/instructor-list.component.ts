import { Component, OnInit } from '@angular/core';
import { Instructor } from '../instructor';
import { InstructorService } from '../instructor.service';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-instructor-list',
  templateUrl: './instructor-list.component.html',
  styleUrls: ['./instructor-list.component.css']
})
export class InstructorListComponent implements OnInit{

  instructors!: Instructor[];

  constructor(private instructorService: InstructorService,private router: Router,private route: ActivatedRoute){

  }
  ngOnInit(): void {
    this.getInstructors();
  }

  private getInstructors(){
    this.instructorService.getInstructorsList().subscribe(data => {
      this.instructors = data;
    });
  }
  updateInstructor(id: number){
    this.router.navigate(['update-instructor', id]);
  }

  instructorDetails(id: number){
    this.router.navigate(['instructor-details',id]);
  }
  addCourse(id: number){
    this.router.navigate(['instructor-course-add',id]);
  }
  viewCourse(id:number){
    this.router.navigate(['instructor-course-list',id]);
  }
  deleteInstructor(id:number){
    this.instructorService.deleteInstructor(id).subscribe( data => {
      console.log(data);
      this.getInstructors();
    })
  }

}
