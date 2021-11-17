package com.hibernate.demo;

import hibernatedemo.entity.Instructor;
import hibernatedemo.entity.InstructorDetail;
import hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory;
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        // create session
        Session session=factory.getCurrentSession();

        try{

            // create the objects
//            Instructor tempInstructor=
//                    new Instructor("krishna","sai","krishnak@gmail.com");
//            InstructorDetail tempInstructorDetail=
//                    new InstructorDetail(
//                            "http://www.luv2code.com/youtude",
//                            "luv to play chess!!!"
//                    );

            Instructor tempInstructor=
                    new Instructor("Sahithi","sai","saisahithi@gmail.com");
            InstructorDetail tempInstructorDetail=
                    new InstructorDetail(
                            "http://www.youtube.com",
                            "luv to sing!!!"
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
            factory.close();
        }


    }
}
