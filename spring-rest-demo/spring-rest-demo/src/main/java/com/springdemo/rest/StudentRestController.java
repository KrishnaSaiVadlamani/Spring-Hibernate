package com.springdemo.rest;

import com.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data ... only once!

    @PostConstruct
    public void loadData(){

        theStudents=new ArrayList<>();
        theStudents.add(new Student("Krishna","Sai"));
        theStudents.add(new Student("Rakesh","Khanna"));
        theStudents.add(new Student("David","Warner"));

    }

    // define endpoint for "/students"
    // return list of all students

    @GetMapping("/students")
    public List<Student> studentList(){
        return theStudents;
    }

    // define endpoint for "/students/{studentId}"
    // return student an index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // just index into the list

        // check the studentId against list size
        if((studentId>=theStudents.size())||(studentId<0)){
            throw new StudentNotFoundException("Student Id not Found : "+studentId);
        }

        return theStudents.get(studentId);

    }





}
