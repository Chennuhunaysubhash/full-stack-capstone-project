import { Component, OnInit } from '@angular/core';
import { InstructorService } from '../instructor.service';
import { Router } from '@angular/router';
import { Instructor } from '../instructor';

@Component({
  selector: 'app-instructor-create',
  templateUrl: './instructor-create.component.html',
  styleUrls: ['./instructor-create.component.css']
})
export class InstructorCreateComponent implements OnInit {

  instructor: Instructor = new Instructor();
  //instructorDetails: InstructorDetails = new InstructorDetails();
 
  constructor(private instructorService: InstructorService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveInstructor(){
    this.instructorService.createInstructor(this.instructor).subscribe( data =>{
      console.log(data);
      this.goToInstructorList();
    },
    error => console.log(error));
  }

  goToInstructorList(){
    this.router.navigate(['/instructor']);
  }
  onSubmit(){
    console.log(this.instructor);
    this.saveInstructor();
  }

  backButton(){
    this.router.navigate(['/instructor']);
  }
}
