package com.pprzybyla.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties for: coach.name and team.name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    // expose new endpoint for "teaminfo"
    public String getTeamInfo() {
        return String.format("Team Name: %s, Coach Name: %s", teamName, coachName);
    }

    // expose "/" that return "Hello World!"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    // expose new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a marathon!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Lucky day!";
    }

}
