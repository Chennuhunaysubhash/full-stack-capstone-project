package com.example.goUpskill.course.entity;

import com.example.goUpskill.instructor.entity.Instructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_generator")
    @SequenceGenerator(name = "course_generator",initialValue = 11,allocationSize = 1,sequenceName = "course_seq")
    private int id;

    @Column(unique = true)
    @NotEmpty(message = "Title should be present")
    @Size(min=3,message = "title should be more than three letters")
    private String title;


    @Min(value = 99,message = "minimum price starts 99 please enter the more than 99 ")
    private int price;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "instructor_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Instructor instructor;

    public Course(){

    }
    public Course(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
