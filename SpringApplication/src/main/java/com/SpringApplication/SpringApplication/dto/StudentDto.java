package com.SpringApplication.SpringApplication.dto;

import com.SpringApplication.SpringApplication.entity.Course;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto
{
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private List<Course> courses;
}
