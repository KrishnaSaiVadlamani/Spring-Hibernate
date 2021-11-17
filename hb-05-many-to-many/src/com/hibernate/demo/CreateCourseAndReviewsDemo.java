package com.hibernate.demo;

import hibernatedemo.entity.Course;
import hibernatedemo.entity.Instructor;
import hibernatedemo.entity.InstructorDetail;
import hibernatedemo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory;
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        // create session
        Session session=factory.getCurrentSession();

        try{

            // start a transaction
            session.beginTransaction();

            // create a course
            Course tempCourse=new Course("Basic Python");

            // add some reviews
            tempCourse.addReview(new Review("It is an easy course"));
            tempCourse.addReview(new Review("Crazy Course"));
            tempCourse.addReview(new Review("I'm Very dumb to understand this easy Course"));

            // save the course...and leverage the cascade all
            System.out.println("Saving thr Course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());
            session.save(tempCourse);
            // commit transaction

            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            // add clean up code
            session.close();

            factory.close();
        }


    }
}
