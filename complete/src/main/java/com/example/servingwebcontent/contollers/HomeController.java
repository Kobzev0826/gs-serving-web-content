package com.example.servingwebcontent.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


    @Controller
    public class HomeController {

        @GetMapping("/home")
        public String home(String name, Model model) {
            model.addAttribute("title", "home page");
            return "home";
        }
    }
