package com.SpringApplication.SpringApplication.controller;

import com.SpringApplication.SpringApplication.dto.CourseDto;
import com.SpringApplication.SpringApplication.dto.CourseMapper;
import com.SpringApplication.SpringApplication.entity.Course;
import com.SpringApplication.SpringApplication.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/courses")
@AllArgsConstructor
public class CourseController {

    // need to inject StudentService
    @Autowired
    private CourseService courseService;

    // add mapping for "/list"
    @GetMapping("/list")
    public String listCourses(Model theModel){


        //List<Course> theCourses=courseService.findAllCourses();
        List<CourseDto> courseDtos= CourseMapper.INSTANCE.toDtos(courseService.findAllCourses());
        // add to the spring model
        theModel.addAttribute("courses",courseDtos);

        return "course/list-courses";

    }


    @GetMapping("/showFormForAdd")
    public String showFormForAddCourse(Model theModel) {

        // create model attribute to bind form data
        //    Course theCourse=new Course();

        CourseDto courseDto=CourseMapper.INSTANCE.toDto(new Course());
        theModel.addAttribute("course", courseDto);

        return "course/course-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdateCourse(@RequestParam("courseId") int theId,
                                    Model theModel) {



  //      Course theCourse = courseService.findCourseById(theId);
        CourseDto courseDto=CourseMapper.INSTANCE.toDto(courseService.findCourseById(theId));

        theModel.addAttribute("course", courseDto);

        // send over to our form
        return "course/course-form";
    }



    @PostMapping("/save")
    public String saveCourse(@Valid @ModelAttribute("course") Course theCourse,
                              BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "course/course-form";
        }

        courseService.saveCourse(theCourse);


        return "redirect:/courses/list";
    }

    @PostMapping("/delete")
    public String deleteCourse(@RequestParam("courseId") int theId){

        courseService.deleteCourseById(theId);

        return "redirect:/courses/list";
    }



}
