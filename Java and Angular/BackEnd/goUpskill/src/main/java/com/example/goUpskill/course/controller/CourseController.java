package com.example.goUpskill.course.controller;

import com.example.goUpskill.course.entity.Course;
import com.example.goUpskill.course.repository.CourseRepository;
import com.example.goUpskill.course.service.CourseServiceImp;
import com.example.goUpskill.instructor.entity.Instructor;
import com.example.goUpskill.instructor.exception.DuplicateUsernameException;
import com.example.goUpskill.instructor.exception.ResourceNotFoundException;
import com.example.goUpskill.instructor.repository.InstructorRepository;
import com.example.goUpskill.instructor.service.InstructorDetailServiceImp;
import jakarta.validation.Valid;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {
    @Autowired
    private CourseServiceImp courseServiceImp;

    @Autowired
    private InstructorDetailServiceImp instructorDetailServiceImp;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/goUpskill/course")
    public ResponseEntity<List<Course>> allCourses(){
        List<Course> temp = courseServiceImp.findAll();
        return ResponseEntity.ok(temp);
    }

    @GetMapping("/goUpskill/course/course/{id}")
    public ResponseEntity<Course> getInstructor(@PathVariable int id){
        Course theInstructor = courseServiceImp.findById(id);
        HttpHeaders header = new HttpHeaders();
        header.add("desc","Instructor get by instructor id");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(theInstructor);
    }

    @GetMapping("/goUpskill/course/{id}")
    public ResponseEntity<List<Course>> getAllCoursesByInstructorId(@PathVariable(value = "id") int instructorId){
        List<Course> theCourse = courseServiceImp.findByInstructorId(instructorId);
        if(theCourse.isEmpty()){
            throw new ResourceNotFoundException();
        }
        HttpHeaders header = new HttpHeaders();
        header.add("desc","Courses get by instructor id");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(theCourse);
    }

    @PostMapping("/goUpskill/course/{id}")
    public ResponseEntity<Course> createCourse(@PathVariable (value = "id") int instructorId, @Valid @RequestBody Course course){
        List<Course> courses = courseServiceImp.duplicateCheckService(course.getTitle());
        if(!courses.isEmpty()){
            throw new DuplicateUsernameException();
        }
        instructorRepository.findById(instructorId).map(instructor->{
            course.setInstructor(instructor);
            return courseServiceImp.save(course);
        }).orElseThrow(()-> new ResourceNotFoundException());
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
    @PutMapping("/goUpskill/course/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable int id, @Valid @RequestBody Course theCourse){
        Course course= courseServiceImp.findById(id);
        if(course==null){
            throw new ResourceNotFoundException();
        }
        course.setId(theCourse.getId());
        course.setTitle(theCourse.getTitle());
        course.setPrice(theCourse.getPrice());
        Course update = courseServiceImp.save(course);
        return ResponseEntity.ok(update);
    }
   /* @PutMapping("/goUpskill/course/{courseId}")
    public ResponseEntity<String> updateCourseDetails(@PathVariable int courseId,@Valid @RequestBody Course course){
        Optional<Course> temp = this.courseRepository.findById(courseId);
        if(temp==null){
            throw new ResourceNotFoundException();
        }
        int price;
        String title;
        price = course.getPrice();
        title=course.getTitle();
        courseServiceImp.updateCourseService(courseId,title,price);
        return ResponseEntity.ok("Update Successfully");
    }*/

    @DeleteMapping("/goUpskill/{instructorId}/course/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable (value = "instructorId") int instructorId, @PathVariable (value="courseId") int courseId){
        courseServiceImp.findByCourseIdAndInstructor(courseId,instructorId).map(course -> {
            courseRepository.delete(course);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException());
        return ResponseEntity.ok("Delete Successfully");
    }

    @DeleteMapping("/goUpskill/course/{id}")
    public ResponseEntity<String> deleteCourseA(@Valid @PathVariable int id){
        Course tempInstructor = courseServiceImp.findById(id);
        if(tempInstructor==null){
            throw new ResourceNotFoundException();
        }
        courseServiceImp.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }











}
