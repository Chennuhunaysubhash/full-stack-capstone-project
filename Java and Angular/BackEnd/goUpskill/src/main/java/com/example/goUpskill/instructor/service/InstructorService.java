package com.example.goUpskill.instructor.service;

import com.example.goUpskill.instructor.entity.Instructor;

import java.util.List;

public interface InstructorService {
    public List<Instructor> findAll();

    public Instructor findById(int theInstructorId);

    public void deleteById(int theInstructorId);

    public Instructor save(Instructor theInstructor);

    public void updateInstructorBasicDetailService(int id,String fN,String lN,String email);

    public List<Instructor> duplicateCheckService(String email);
}
