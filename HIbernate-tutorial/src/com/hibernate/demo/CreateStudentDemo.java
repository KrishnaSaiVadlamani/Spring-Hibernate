package com.hibernate.demo;

import hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
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
            Student tempStudent=new Student("Krishna","Sai","krishnakittu2421@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the Student...");

            session.save(tempStudent);

            // commit transaction

            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            factory.close();
        }


    }
}
