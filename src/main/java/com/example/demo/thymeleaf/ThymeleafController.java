package com.example.demo.thymeleaf;

import com.example.demo.resttemplate.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThymeleafController {

    private static final Logger log = LoggerFactory.getLogger(ThymeleafController.class);

    @GetMapping("/home")
    public String home(Model model) {

        Student student = new Student();
        student.setId(1);
        student.setName("Amy");

        model.addAttribute("myStudent", student);

        return "index";
    }

    @GetMapping("/hello")
    public String hello() {

        return "hello";
    }

    @PostMapping("/login")
    public String login(String userName,
                        String userPassword) {

        log.info("name: {}", userName);
        log.info("password: {}", userPassword);

        return "login";
    }
}
