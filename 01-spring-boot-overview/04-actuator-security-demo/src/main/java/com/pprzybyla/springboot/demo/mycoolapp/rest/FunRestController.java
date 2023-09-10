package com.pprzybyla.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

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
