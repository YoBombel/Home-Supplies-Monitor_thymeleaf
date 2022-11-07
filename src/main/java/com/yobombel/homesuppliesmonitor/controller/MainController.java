package com.yobombel.homesuppliesmonitor.controller;

import com.yobombel.homesuppliesmonitor.model.User;
import com.yobombel.homesuppliesmonitor.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("")
    public String startPage(Model model){
        model.addAttribute("users", userService.findAllUsers());
        return "start";
    }

}