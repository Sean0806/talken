package com.talken.talken.controller;

import com.talken.talken.model.ResultCode;
import com.talken.talken.model.UserData;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping({"/", "/index.html"})
    public ModelAndView index(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView();
        //判断session
        if (!StringUtils.isEmpty(session.getAttribute("username"))) {
            mav.setViewName("index");
        } else {
            mav.setViewName("login.html");
        }
        //如果不为空
        return mav;
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public ResultCode login(@RequestBody UserData user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ResultCode resultCode = new ResultCode();
//        UserData user = new UserData();
        if (!StringUtils.isEmpty(user)) {
            if (user.getUserName().equals("admin") && user.getPassword().equals("admin")) {
                session.setAttribute("username",user.getUserName());
                session.setAttribute("password",user.getPassword());
            }
            resultCode.setResultCode("success");
        } else {
            resultCode.setResultCode("failed");
        }
        return resultCode;
//        return "index";
    }
}
