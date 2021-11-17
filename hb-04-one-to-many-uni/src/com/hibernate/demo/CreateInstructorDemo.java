package com.hibernate.demo;

import hibernatedemo.entity.Course;
import hibernatedemo.entity.Instructor;
import hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory;
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        // create session
        Session session=factory.getCurrentSession();

        try{

            // create the objects
            Instructor tempInstructor=
                    new Instructor("Krishna","sai","KS@gmail.com");
            InstructorDetail tempInstructorDetail=
                    new InstructorDetail(
                            "http://www.youtube.com",
                            "luv to play chess!!!"
                    );

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // start a transaction
            session.beginTransaction();

            // save the instructor
            //
            // Note: this will also save the details object
            // because of CascadeType.ALL
            //
            System.out.println("Saving Instructor: "+tempInstructor);
            session.save(tempInstructor);

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
