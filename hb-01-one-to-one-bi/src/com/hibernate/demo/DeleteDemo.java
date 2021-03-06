package com.hibernate.demo;

import hibernatedemo.entity.Instructor;
import hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
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

            // start a transaction
            session.beginTransaction();

            // get instructor by primary key/id
            int theId=2;
            Instructor tempInstructor=
                    session.get(Instructor.class,theId);

            System.out.println("Found instructor: "+tempInstructor);
            // delete the instructors

            if(tempInstructor!=null){
                System.out.println("Deleting: "+tempInstructor);

                // Note: will also delete associated "details" object
                // because of CascadeType.ALL
                //
                session.delete(tempInstructor);
            }

            // commit transaction

            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            factory.close();
        }


    }
}
