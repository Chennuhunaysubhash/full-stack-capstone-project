package com.example.goUpskill.instructor.service;

import com.example.goUpskill.instructor.entity.InstructorDetail;
import com.example.goUpskill.instructor.exception.ResourceNotFoundException;
import com.example.goUpskill.instructor.repository.InstructorDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorDetailServiceImp implements InstructorDetailService{

    @Autowired
    private InstructorDetailRepository instructorDetailRepository;
    @Override
    public List<InstructorDetail> findAll() {
        return instructorDetailRepository.findAll();
    }

    @Override
    public InstructorDetail findById(int theInstructorId) {
        Optional<InstructorDetail> result = instructorDetailRepository.findById(theInstructorId);
        InstructorDetail theInstructor = null;
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
    instructorDetailRepository.deleteById(theInstructorId);
    }

    @Override
    public void updateInstructorMoreDetailsService(int id, String github, String linkedIn, String des) {
      instructorDetailRepository.updateInstructorMoreDetail(id,github,linkedIn,des);
    }

    @Override
    public InstructorDetail save(InstructorDetail theInstructor) {
        return instructorDetailRepository.save(theInstructor);
    }
}
