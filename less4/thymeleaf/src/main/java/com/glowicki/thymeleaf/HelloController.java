package com.glowicki.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping
    public String get(Model model) {
        model.addAttribute("name", "Przmek");
        return "hello";
    }
}
