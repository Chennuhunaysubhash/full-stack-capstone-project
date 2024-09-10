import { Component, OnInit } from '@angular/core';
import { Instructor } from '../instructor';
import {InstructorService} from '../instructor.service'
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-instructor-update',
  templateUrl: './instructor-update.component.html',
  styleUrls: ['./instructor-update.component.css']
})
export class InstructorUpdateComponent  implements OnInit {

  id!:number;
  instructor: Instructor = new Instructor();
  constructor(private instructorService: InstructorService, private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.instructorService.getInstructorById(this.id).subscribe(data => {
      this.instructor = data;
    }, error => console.log(error));
  }
  
  onSubmit(){
    this.instructorService.updateInstructor(this.id, this.instructor).subscribe( data =>{
      this.goToInstructorList();
    }
    , error => console.log(error));
  }

  goToInstructorList(){
    this.router.navigate(['/instructor']);
  }
  backButton(){
    this.router.navigate(['/instructor']);
  }

}
