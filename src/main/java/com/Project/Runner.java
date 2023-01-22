package com.Project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        Instructor instructor1 = new Instructor("Tom", "Hanks", "th@gmail.com");
        Instructor instructor2 = new Instructor("Angelina", "Jolie", "aj@gmail.com");

        InstructorDetail instructorDetail1 = new InstructorDetail("YouTube1", "Hiking", instructor1);
        InstructorDetail instructorDetail2 = new InstructorDetail("YouTube2", "Swimming", instructor2);

        Course course1 = new Course("Java", instructor1);
        Course course2 = new Course("Python", instructor1);
        Course course3 = new Course("ReactJS", instructor2);
        Course course4 = new Course("TypeJS", instructor2);
        List<Course> courseList1 = Arrays.asList(course1, course2);
        List<Course> courseList2 = Arrays.asList(course3, course4);
        List<Course> courseList3 = Arrays.asList(course1, course4);

        Students student1 = new Students("Ali", "Han", "ah@gmail.com");
        Students student2 = new Students("Veli", "Can", "vc@gmail.com");

        Review review1 = new Review("The worst");
        Review review2 = new Review("Bad");
        Review review3 = new Review("Good");
        Review review4 = new Review("The best");

        student1.setCourseList(courseList1);
        student2.setCourseList(courseList3);
        review1.setCourse(course1);
        review2.setCourse(course1);
        review3.setCourse(course2);
        review4.setCourse(course2);
        instructor1.setCourseList(courseList1);
        instructor2.setCourseList(courseList2);



        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(instructor1);
        session.save(instructor2);
        session.save(instructorDetail1);
        session.save(instructorDetail2);
        session.save(course1);
        session.save(course2);
        session.save(course3);
        session.save(course4);
        session.save(student1);
        session.save(student2);
        session.save(review1);
        session.save(review2);
        session.save(review3);
        session.save(review4);


        tx.commit();
        session.close();
        sf.close();


    }
}
