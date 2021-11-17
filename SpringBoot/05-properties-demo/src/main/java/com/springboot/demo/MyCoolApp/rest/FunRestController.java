package com.springboot.demo.MyCoolApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    // inject properties for: coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for "teaminfo"
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: " + coachName + ", Team Name: " + teamName;
    }

    // expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){

        return "Hello World! Time on the Server is "+ LocalDateTime.now();

    }

    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkOut(){
        return "Run 5k!!!";
    }

    // expose a new endpoint for "Fortune"
    @GetMapping("/fortune")
    public String getFortune(){
        return "Today is your Lucky Day!!!";
    }

}
