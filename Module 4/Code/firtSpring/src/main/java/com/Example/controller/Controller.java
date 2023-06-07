package com.Example.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String show(){
        return "/hello";
    }
}
