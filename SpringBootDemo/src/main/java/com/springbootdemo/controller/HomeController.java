package com.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/sayHello")
    public String sayHello() {
        System.out.println("Called Method");
        return "sayHello";
    }
}


