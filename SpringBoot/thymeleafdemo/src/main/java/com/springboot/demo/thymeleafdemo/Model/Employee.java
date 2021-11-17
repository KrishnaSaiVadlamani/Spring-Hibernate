package com.springboot.demo.thymeleafdemo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Employee {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

}
