import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Instructor } from './instructor';
import { Course } from './course';

@Injectable({
  providedIn: 'root'
})
export class InstructorService {

  private baseURL = "http://localhost:8099/instructor";
  private courseURL ="http://localhost:8099/goUpskill/course";
  constructor(private httpClient:HttpClient) { }

  getInstructorsList(): Observable<Instructor[]>{
    return this.httpClient.get<Instructor[]>(`${this.baseURL}`);
  }
  createInstructor(instructor: Instructor): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, instructor);
  }

  getInstructorById(id: number): Observable<Instructor>{
    return this.httpClient.get<Instructor>(`${this.baseURL}/${id}`);
  }
   
  updateInstructor(id: number, instructor: Instructor): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, instructor);
  }

  deleteInstructor(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

  addCourse(id:number, course:Course): Observable<Object>{
    return this.httpClient.post(`${this.courseURL}/${id}`,course);
  }

  getCoruse(id: number): Observable<Course[]>{
    return this.httpClient.get<Course[]>(`${this.courseURL}/${id}`);
  }
}
