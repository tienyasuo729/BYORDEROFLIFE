package com.Codegym.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@RequestMapping("/hello")
public class Controller {
    @GetMapping("/show2")
    public String show(){
        return "demo";
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public String addif(@RequestParam int id, @RequestParam String name, Model model){
        model.addAttribute("showif", id + " / " + name);
        return "forward:/hello/show2";
//        return "demo";
    }
}
