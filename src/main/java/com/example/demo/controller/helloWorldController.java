package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {
    @RequestMapping("/")
    public String Home(){
        return "HEEELP! THE BOSS IS FORCING ME TO DEVELOP USING JAVA!";
    }

    @RequestMapping("/hello")
    public String HelloWorld() {
        return "does this works?";
    }
}