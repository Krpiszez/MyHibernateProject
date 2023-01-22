package com.Project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "std_fName", length = 100, nullable = false)
    private String fName;

    @Column(name = "std_lName", length = 100, nullable = false)
    private String lName;

    @Column(name = "std_email", length = 100, nullable = false, unique = true)
    private String email;

    @ManyToMany
    @JoinTable(name = "course_student"
            , joinColumns = {@JoinColumn(name = "std_id")}
            , inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Course> courseList = new ArrayList<>();

    public Students() {
    }

    public Students(String fName, String lName, String email) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}
