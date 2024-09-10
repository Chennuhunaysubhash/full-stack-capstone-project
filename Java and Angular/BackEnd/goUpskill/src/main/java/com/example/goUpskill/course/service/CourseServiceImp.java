package com.example.goUpskill.course.service;

import com.example.goUpskill.course.entity.Course;
import com.example.goUpskill.course.repository.CourseRepository;
import com.example.goUpskill.instructor.entity.Instructor;
import com.example.goUpskill.instructor.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImp implements CourseService{

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public List<Course> findByInstructorId(int instructorId) {
        return courseRepository.findByInstructorId(instructorId);
    }

    @Override
    public Optional<Course> findByCourseIdAndInstructor(int id, int instructorId) {
        return courseRepository.findByIdAndInstructorId(id,instructorId);
    }

    @Override
    public Course findById(int theInstructorId) {
        Optional<Course> result = courseRepository.findById(theInstructorId);
        Course theInstructor = null;
        if(result.isPresent()){
            theInstructor=result.get();
        }
        else {
            throw new ResourceNotFoundException();
        }
        return theInstructor;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> duplicateCheckService(String title) {
        return courseRepository.duplicateCheck(title);
    }

    @Override
    public void updateCourseService(int id, String title, int price) {
    courseRepository.updateCourse(id, title, price);
    }

    @Override
    public void deleteById(int courseId) {
        courseRepository.deleteById(courseId);
    }
}
