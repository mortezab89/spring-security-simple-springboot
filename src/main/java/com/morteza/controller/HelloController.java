package com.morteza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping(value = {"/", "/welcome"})
    @ResponseBody
    public String defaulty(){
        return "hello";
    }
//    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
//    public ModelAndView welcomePage() {
//
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "Spring Security Hello World");
//        model.addObject("message", "This is welcome page!");
//        model.setViewName("hello");
//        return model;
//
//    }

//    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
//    public ModelAndView adminPage() {
//
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "Spring Security Hello World");
//        model.addObject("message", "This is protected page - Admin Page!");
//        model.setViewName("admin");
//
//        return model;
//
//    }

    @GetMapping(value = "/admin**")
    @ResponseBody
    public String adminPage() {

        return "admin";

    }

//    @RequestMapping(value = "/dba**", method = RequestMethod.GET)
//    public ModelAndView dbaPage() {
//
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "Spring Security Hello World");
//        model.addObject("message", "This is protected page - Database Page!");
//        model.setViewName("admin");
//
//        return model;
//
//    }

    @GetMapping(value = "/dba**")
    @ResponseBody
    public String dbaPage() {

        return "dba";

    }

}
