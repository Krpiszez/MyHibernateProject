package com.Project;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ins_fName", length = 100, nullable = false)
    private String fName;

    @Column(name = "ins_lName", length = 100, nullable = false)
    private String lName;

    @Column(name = "ins_email", length = 100, nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courseList = new ArrayList<>();

    private LocalDateTime createdDate;
    @PrePersist
    public void prePersist(){ //here we set the time when the data being saved for the first time ? to db
        createdDate = LocalDateTime.now();
    }


    public Instructor() {
    }

    public Instructor(String fName, String lName, String email) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
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

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
