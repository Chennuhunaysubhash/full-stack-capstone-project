import { Component, OnInit } from '@angular/core';
import { InstructorCreateComponent } from '../instructor-create/instructor-create.component';
import { Instructor } from '../instructor';
import { ActivatedRoute,Router } from '@angular/router';
import { InstructorService } from '../instructor.service';

@Component({
  selector: 'app-instructor-details',
  templateUrl: './instructor-details.component.html',
  styleUrls: ['./instructor-details.component.css']
})
export class InstructorDetailsComponent implements OnInit {

  id!:number;
  instructor!:Instructor;
  constructor(private route: ActivatedRoute, private instructorService:InstructorService,private router: Router){

  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.instructor = new Instructor();
    this.instructorService.getInstructorById(this.id).subscribe( data => {
      this.instructor = data;
    });
  }
  backButton(){
    this.router.navigate(['instructor']);
  }

}
