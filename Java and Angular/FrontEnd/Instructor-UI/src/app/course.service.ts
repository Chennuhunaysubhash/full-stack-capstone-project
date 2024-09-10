import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Course } from './course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private courseURL ="http://localhost:8099/goUpskill/course";
  private course2URL = "http://localhost:8099/goUpskill/course/course";
  constructor(private httpClient:HttpClient) { }

  getCourseList(): Observable<Course[]>{
    return this.httpClient.get<Course[]>(`${this.courseURL}`);
  }
  getCourseById(id: number): Observable<Course>{
    return this.httpClient.get<Course>(`${this.course2URL}/${id}`);
  }
   
  updateCourse(id: number, course: Course): Observable<Object>{
    return this.httpClient.put(`${this.courseURL}/${id}`, course);
  }
  deleteCourse(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.courseURL}/${id}`);
  }

}
