package com.example.goUpskill.instructor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "instructor_generator")
    @SequenceGenerator(name = "instructor_generator",initialValue =
            501,allocationSize = 1,sequenceName = "instructor_Detail_seq")
    private int id;
    @Column(unique = true)
    @NotEmpty(message = "should be enter value in this filed")
    private String github;
    @Column(unique = true)
    @NotEmpty(message = "should be enter value in this filed")
    private String linkedIn;

    @NotEmpty(message = "should be enter value in this filed")
    @Size(min=8,max = 50,message = "should be enter no of character in between range 8 to 50")
    private String des;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "instructorDetail",cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Instructor instructor;
    public InstructorDetail(){

    }
    public InstructorDetail(String github, String linkedIn, String des) {
        this.github = github;
        this.linkedIn = linkedIn;
        this.des = des;
    }

    public InstructorDetail(int id, String github, String linkedIn, String des) {
        this.id = id;
        this.github = github;
        this.linkedIn = linkedIn;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
