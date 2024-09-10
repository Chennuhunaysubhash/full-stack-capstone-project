package com.example.goUpskill.instructor.entity;

import com.example.goUpskill.course.entity.Course;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "instructor_generator")
    @SequenceGenerator(name = "instructor_generator",initialValue =
    501,allocationSize = 1,sequenceName = "instructor_seq")
    private int id;
    @Column(unique = true)
    @NotEmpty(message = "first name should be present")
    @Size(min = 3,message = "first name should be more than three letters")
    private String firstName;
    @Column(unique = true)
    @NotEmpty(message = "last name should be present")
    @Size(min = 3,message = "last name should be more than three letters")
    private String lastName;

    @Column(unique = true)
    @NotEmpty(message = "email should be present")
    @Email(message = "should be email format")
    private String email;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_id")
    private InstructorDetail instructorDetail;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;

    public  Instructor(){

    }
    public Instructor( String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Instructor(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Instructor(String firstName, String lastName, String email, InstructorDetail instructorDetail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.instructorDetail = instructorDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
