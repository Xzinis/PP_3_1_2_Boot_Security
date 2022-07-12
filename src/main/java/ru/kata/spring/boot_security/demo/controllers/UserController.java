package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserDetailServic;
import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserDetailServic userDetailService;

    public UserController(UserDetailServic userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping()
    public String show(Principal principal, Model model) {
        User user = userDetailService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }
}