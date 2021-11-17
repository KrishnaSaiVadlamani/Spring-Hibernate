package com.hibernate.demo;

import hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory;
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session=factory.getCurrentSession();

        try{

            // create a student object
            System.out.println("Creating new Student Object");
            Student tempStudent=new Student("hola","chika","holachika@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the Student...");
            System.out.println(tempStudent);

            session.save(tempStudent);

            // commit transaction

            session.getTransaction().commit();

            // My new Code

            // find out the student's id : primary key
            System.out.println("Saved Student, generated id: "+tempStudent.getId());

            // now get a new session and start transaction
            session=factory.getCurrentSession();
            session.beginTransaction();
            // retrieve student based on id: primary key
            System.out.println("\nGetting Student with id: "+tempStudent.getId());
            Student myStudent=session.get(Student.class,tempStudent.getId());
            System.out.println("Get Complete: "+myStudent);
            // commit the transaction
            session.getTransaction().commit();





            System.out.println("Done!");

        }
        finally {
            factory.close();
        }


    }
}
