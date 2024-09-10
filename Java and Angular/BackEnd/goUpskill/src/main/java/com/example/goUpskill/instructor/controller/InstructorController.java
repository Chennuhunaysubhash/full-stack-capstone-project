package com.example.goUpskill.instructor.controller;

import com.example.goUpskill.instructor.entity.Instructor;
import com.example.goUpskill.instructor.entity.InstructorDetail;
import com.example.goUpskill.instructor.exception.DuplicateUsernameException;
import com.example.goUpskill.instructor.exception.ResourceNotFoundException;
import com.example.goUpskill.instructor.service.InstructorDetailService;
import com.example.goUpskill.instructor.service.InstructorDetailServiceImp;
import com.example.goUpskill.instructor.service.InstructorServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InstructorController {

    @Autowired
    private InstructorServiceImp instructorServiceImp;
    @Autowired
    private InstructorDetailServiceImp instructorDetailServiceImp;

    @GetMapping("/instructor")
    public ResponseEntity<List<Instructor>> allInstructor(){
        List<Instructor> temp = instructorServiceImp.findAll();
        return ResponseEntity.ok(temp);
    }

    @GetMapping("/instructor/{id}")
    public ResponseEntity<Instructor> getInstructor(@PathVariable int id){
        Instructor theInstructor = instructorServiceImp.findById(id);
        HttpHeaders header = new HttpHeaders();
        header.add("desc","Instructor get by instructor id");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(theInstructor);
    }

    @DeleteMapping("/instructor/{id}")
    public ResponseEntity<String> deleteInstructor(@Valid @PathVariable int id){
        Instructor tempInstructor = instructorServiceImp.findById(id);
        if(tempInstructor==null){
            throw new ResourceNotFoundException();
        }
        instructorServiceImp.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @PostMapping("/instructor")
    public ResponseEntity<Instructor> addInstructor(@Valid @RequestBody Instructor instructor){
        List<Instructor> instructors= instructorServiceImp.duplicateCheckService(instructor.getEmail());
        if(!instructors.isEmpty()){
            throw new DuplicateUsernameException();
        }
        Instructor addInstructor =this.instructorServiceImp.save(instructor);
        return new ResponseEntity<>(addInstructor,HttpStatus.CREATED);
    }

    @PutMapping("/instructor/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable int id,@Valid @RequestBody Instructor theInstructor){
        Instructor instructor= instructorServiceImp.findById(id);
        if(instructor==null){
            throw new ResourceNotFoundException();
        }
        instructor.setFirstName(theInstructor.getFirstName());
        instructor.setLastName(theInstructor.getLastName());
        instructor.setEmail(theInstructor.getEmail());
        Instructor update = instructorServiceImp.save(instructor);
        return ResponseEntity.ok(update);
    }

    @PutMapping("/instructor/updateDetails")
    public ResponseEntity<String> updateInstructorWithNewDetails(@Valid @RequestBody Instructor instructor){
         Instructor temp = this.instructorServiceImp.findById(instructor.getId());
         if(temp==null){
             throw new ResourceNotFoundException();
         }
         int id;
         String fn,ln,email;
         fn=instructor.getFirstName();
         ln=instructor.getLastName();
         email=instructor.getEmail();
         id=instructor.getId();
         instructorServiceImp.updateInstructorBasicDetailService(id,fn,ln,email);
         return ResponseEntity.ok("Update Successfully");
    }

    @GetMapping("/instructor/more/all")
    public ResponseEntity<List<InstructorDetail>> allInstructorMore(){
        List<InstructorDetail> temp = instructorDetailServiceImp.findAll();
        return  ResponseEntity.ok(temp);
    }

    @GetMapping("/instructor/more/{id}")
    public ResponseEntity<InstructorDetail> getInstructorMore(@PathVariable int id){
        InstructorDetail temp = instructorDetailServiceImp.findById(id);
        HttpHeaders header = new HttpHeaders();
        header.add("desc","Instructor details get by instructor id");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(temp);
    }

    @PutMapping("/instructor/more/updateDetails")
    public ResponseEntity<String> updateInstructorWithNewMoreDetails(@Valid @RequestBody InstructorDetail instructorDetail){
        InstructorDetail temp = instructorDetailServiceImp.findById(instructorDetail.getId());
        if(temp==null){
            throw new ResourceNotFoundException();
        }
        int id;
        String fn,ln,des;
        fn=instructorDetail.getGithub();
        ln=instructorDetail.getLinkedIn();
        des=instructorDetail.getDes();
        id=instructorDetail.getId();
        instructorDetailServiceImp.updateInstructorMoreDetailsService(id,fn,ln,des);
        return ResponseEntity.ok("update successfully");
    }

    /* testing still pending, casecade delete off mode
    @DeleteMapping("/instructor/more/delete/{id}")
    public ResponseEntity<String> deleteInstructorMore(@Valid @PathVariable int id){
        InstructorDetail temp = instructorDetailServiceImp.findById(id);
        if(temp==null){
            throw new ResourceNotFoundException();
        }
        instructorDetailServiceImp.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }*/

    @PostMapping("/instructorDetails")
    public ResponseEntity<InstructorDetail> addInstructor(@Valid @RequestBody InstructorDetail instructor){
        InstructorDetail addInstructor =this.instructorDetailServiceImp.save(instructor);
        return new ResponseEntity<>(addInstructor,HttpStatus.CREATED);
    }



















}
