package com.example.goUpskill.instructor.service;

import com.example.goUpskill.instructor.entity.Instructor;
import com.example.goUpskill.instructor.entity.InstructorDetail;

import java.util.List;

public interface InstructorDetailService {
    public List<InstructorDetail> findAll();
    public InstructorDetail findById(int theInstructorId);
    public void deleteById(int theInstructorId);

    public void updateInstructorMoreDetailsService(int id,String github,String linkedIn,String des);

    public InstructorDetail save(InstructorDetail theInstructor);

}
