package com.example.goUpskill.instructor.repository;

import com.example.goUpskill.instructor.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail,Integer> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update InstructorDetail i set i.github= :github, i.linkedIn= :linkedIn,i.des= :des where i.id= :id")
    void updateInstructorMoreDetail(@Param(value = "id") int id, @Param(value = "github") String github, @Param(value = "linkedIn") String linkedIn, @Param(value = "des") String des);

}
