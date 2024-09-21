package com.iago.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.iago.curso.springboot.webapp.springboot_web.models.User;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){//Works with Map<String, Object> insted of model too
        User user = new User("iago", "porto");
        model.addAttribute("title", "Primer trabajo en Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

}
