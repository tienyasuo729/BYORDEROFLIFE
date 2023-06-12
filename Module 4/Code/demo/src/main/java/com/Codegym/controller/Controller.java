package com.Codegym.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/hello")
public class Controller {
    @GetMapping("/show2")
    public String show(){
        return "demo";
    }
}
