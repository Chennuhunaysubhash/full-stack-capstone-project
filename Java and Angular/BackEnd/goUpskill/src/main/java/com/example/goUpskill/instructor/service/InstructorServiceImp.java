package com.example.goUpskill.instructor.service;

import com.example.goUpskill.instructor.entity.Instructor;
import com.example.goUpskill.instructor.exception.ResourceNotFoundException;
import com.example.goUpskill.instructor.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InstructorServiceImp implements InstructorService{

    @Autowired
    private InstructorRepository instructorRepository;
    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor findById(int theInstructorId) {
        Optional<Instructor> result = instructorRepository.findById(theInstructorId);
        Instructor theInstructor = null;
        if(result.isPresent()){
            theInstructor=result.get();
        }
        else {
            throw new ResourceNotFoundException();
        }
        return theInstructor;
    }

    @Override
    public void deleteById(int theInstructorId) {
        instructorRepository.deleteById(theInstructorId);
    }

    @Override
    public Instructor save(Instructor theInstructor) {
        return instructorRepository.save(theInstructor);
    }

    @Override
    public void updateInstructorBasicDetailService(int id, String fN, String lN, String email) {
        instructorRepository.updateInstructorBasicDetail(id,fN,lN,email);
    }

    @Override
    public List<Instructor> duplicateCheckService(String email) {
        return instructorRepository.duplicateCheck(email);
    }
}
