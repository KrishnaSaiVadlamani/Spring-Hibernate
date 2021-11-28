package com.SpringApplication.SpringApplication.controller;

import com.SpringApplication.SpringApplication.config.StudentUserDetails;
import com.SpringApplication.SpringApplication.dto.CourseDto;
import com.SpringApplication.SpringApplication.dto.CourseMapper;
import com.SpringApplication.SpringApplication.dto.StudentDto;
import com.SpringApplication.SpringApplication.dto.StudentMapper;
import com.SpringApplication.SpringApplication.entity.Course;
import com.SpringApplication.SpringApplication.entity.Student;
import com.SpringApplication.SpringApplication.service.CourseService;
import com.SpringApplication.SpringApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    // need to inject StudentService
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    // add mapping for "/list"
    @GetMapping("/list")
    public String listStudents(Model theModel){

        // get students from db
 //       List<Student> theStudents=studentService.findAllStudents();
        List<StudentDto> studentDtos= StudentMapper.INSTANCE.toDtos(studentService.findAllStudents());

        // add to the spring model
        theModel.addAttribute("students",studentDtos);

        return "student/list-students";

    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdateStudent(@RequestParam("studentId") int theId,
                                    Model theModel) {


        // get the student from the service
     //   Student theStudent = studentService.findStudentById(theId);
        StudentDto studentDto=StudentMapper.INSTANCE.toDto(studentService.findStudentById(theId));

        // set student as a model attribute to pre-populate the form
        theModel.addAttribute("student", studentDto);

    //    List<Course> theCourse=courseService.findAllCourses();
        List<CourseDto> courseDtos= CourseMapper.INSTANCE.toDtos(courseService.findAllCourses());

        theModel.addAttribute("theCourse",courseDtos);

        // send over to our form
        return "student/student-update-form";
    }


    @GetMapping("/showMyPage")
    public String showMyPageStudent(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        StudentUserDetails userDetails = (StudentUserDetails)auth.getPrincipal();
        String emailId = userDetails.getUsername();
       // Student student = studentService.findStudentByEmail(emailId);
        StudentDto studentDto=StudentMapper.INSTANCE.toDto(studentService.findStudentByEmail(emailId));
        model.addAttribute("student",studentDto);
        return "student-page";
    }


    @GetMapping("/showAccount")
    public String showStudentAccountPage(@RequestParam("studentId") int id,Model model){
     //   Student student = studentService.findStudentById(id);
        StudentDto studentDto=StudentMapper.INSTANCE.toDto(studentService.findStudentById(id));
        model.addAttribute("student",studentDto);
        return "student/account-page";
    }

    @PostMapping("/update")
    public String updateStudent(@Valid @ModelAttribute("student") Student theStudent
    ){
        // update the student
        studentService.saveStudent(theStudent);

        return "student/update-success";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") int theId){
        // delete student
        studentService.deleteStudentById(theId);
        // redirect to /students/list
        return "redirect:/students/list";
    }

}
