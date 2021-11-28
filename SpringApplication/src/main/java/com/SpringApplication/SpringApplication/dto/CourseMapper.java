package com.SpringApplication.SpringApplication.dto;

import com.SpringApplication.SpringApplication.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CourseMapper {

    CourseMapper INSTANCE= Mappers.getMapper(CourseMapper.class);

    CourseDto toDto(Course course);

    List<CourseDto> toDtos(List<Course> courses);


}
