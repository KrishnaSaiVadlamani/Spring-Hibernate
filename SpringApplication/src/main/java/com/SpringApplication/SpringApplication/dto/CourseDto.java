package com.SpringApplication.SpringApplication.dto;

import com.SpringApplication.SpringApplication.entity.Course;
import com.SpringApplication.SpringApplication.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class CourseDto {

    private int id;

    private String title;

    private List<Student> students;

}
