package com.hibernate.demo;

import hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory;
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session=factory.getCurrentSession();

        try{

              int studentId=4;

              // now get a new session and start transaction
              session=factory.getCurrentSession();
              session.beginTransaction();

              // retrieve student based on id: primary key
            System.out.println("\nGetting Student with id: "+studentId);

            Student myStudent=session.get(Student.class,studentId);

            // delete the student
//            System.out.println("Deleting Student: "+myStudent);
//            session.delete(myStudent);


            // delete student id=2

            System.out.println("Deleting Student id=2");
            session.createQuery("delete from Student where id=2").executeUpdate();

            // commit the transaction
            session.getTransaction().commit();



            System.out.println("Done!");

        }
        finally {
            factory.close();
        }


    }
}
