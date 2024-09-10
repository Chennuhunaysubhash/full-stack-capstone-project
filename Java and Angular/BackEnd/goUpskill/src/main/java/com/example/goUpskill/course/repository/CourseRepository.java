package com.example.goUpskill.course.repository;

import com.example.goUpskill.course.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org .springframework .data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByInstructorId(int instructorId);

    Optional<Course> findByIdAndInstructorId(int id, int courseId);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("select c from Course c where c.title = :title")
    List<Course> duplicateCheck(@Param("title") String title);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Course c set c.title = :title, c.price = :price where c.id = :id")
    void updateCourse(@Param("id") int id, @Param("title") String title, @Param("price") int price);

}
