package com.hibernate.demo;

import hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory;
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session=factory.getCurrentSession();

        try{
            // start a transaction
            session.beginTransaction();

            // query students

            List<Student> theStudents= session.createQuery("from Student").list();



            // display the students
            displayStudents(theStudents);

            // query students: lastname = 'Sai'
            theStudents=session.createQuery("from Student s where s.lastName='Sai'").list();


            // display the students
            System.out.println("\n\nStudents who have last name of Sai");
            displayStudents(theStudents);


            // query students: lastName='Sai' or firstName='Ravi'

            theStudents=session.createQuery("from Student s where "+" s.lastName='Sai' or s.firstName='Ravi'").list();
            System.out.println("\n\nStudents who have last name of Sai or firstName of Ravi");
            displayStudents(theStudents);

            // query students where email like '%gmail.com'

            theStudents=session.createQuery("from Student s where"+" s.email like '%gmail.com'").list();
            System.out.println("\n\nStudents who have mail's ending with gmail.com ");
            displayStudents(theStudents);





            // commit transaction

            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            factory.close();
        }


    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }
}
