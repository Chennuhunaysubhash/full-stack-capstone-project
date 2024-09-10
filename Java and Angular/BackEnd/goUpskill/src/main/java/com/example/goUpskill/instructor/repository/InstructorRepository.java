package com.example.goUpskill.instructor.repository;

import com.example.goUpskill.instructor.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Integer> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Instructor i set i.firstName= :firstName, i.lastName= :lastName,i.email= :email where i.id= :id")
    void updateInstructorBasicDetail(@Param(value = "id") int id, @Param(value = "firstName") String firstName, @Param(value = "lastName") String lastName,@Param(value = "email") String email);

    @Query("select i from Instructor i where i.email= :email")
    List<Instructor> duplicateCheck(@Param(value = "email") String email);

}
