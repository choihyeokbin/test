package com.example.pc.controller;


import com.example.pc.auth.AuthUser;
import com.example.pc.auth.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class mainController {


    @Autowired
    private UserDetailServiceImpl userDetailService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String main(Authentication auth){
      return "/main";
    }

    @RequestMapping("/login")
    public String loginView(HttpServletRequest req){

        return "/login";
    }

    @RequestMapping("/admin")
    public String admin(@AuthenticationPrincipal UserDetails user, HttpServletRequest req, Model model){
        model.addAttribute("err",req.getParameter("errorMsg"));

        return "/admin";
    }
    @RequestMapping("/user")
    public String user(@AuthenticationPrincipal UserDetails user, HttpServletRequest req, Model model){
        model.addAttribute("err",req.getParameter("errorMsg"));

        return "/admin";
    }
    @RequestMapping("/denied")
    public String denied(){
        return "/denied";
    }
}
