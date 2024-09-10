package com.example.goUpskill.course.service;

import com.example.goUpskill.course.entity.Course;
import com.example.goUpskill.instructor.entity.Instructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CourseService {
    List<Course> findByInstructorId(int instructorId);
    Optional<Course> findByCourseIdAndInstructor(int id, int instructorId);
    public Course findById(int theInstructorId);
    public List<Course> findAll();
    public Course save(Course course);
    public List<Course> duplicateCheckService(String title);
    public void updateCourseService(int id,String title,int price);
    public void deleteById(int couseId);
}
