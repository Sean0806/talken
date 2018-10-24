package com.talken.talken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping({"/", "/index.html"})
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        //判断session
        //如果为空
        mav.setViewName("login");
        //如果不为空
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "index";
    }
}
