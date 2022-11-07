package com.yobombel.homesuppliesmonitor.controller;

import com.yobombel.homesuppliesmonitor.model.User;
import com.yobombel.homesuppliesmonitor.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("userpage")
    public String userPage(){
        return "userPage";
    }

    @PostMapping("newUser")
    public String newUser(@RequestParam String name){
        userService.createNewUser(new User(name));
        return "userPage";
    }

}