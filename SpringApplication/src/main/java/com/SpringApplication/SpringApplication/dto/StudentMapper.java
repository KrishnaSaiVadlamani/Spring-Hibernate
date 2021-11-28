package com.SpringApplication.SpringApplication.dto;

import com.SpringApplication.SpringApplication.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface StudentMapper {


        StudentMapper INSTANCE= Mappers.getMapper(StudentMapper.class);

        StudentDto toDto(Student student);

        List<StudentDto> toDtos(List<Student> students);

        Student toEntity(StudentDto studentDto);

}


