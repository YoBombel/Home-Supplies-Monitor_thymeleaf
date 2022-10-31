package com.yobombel.homesuppliesmonitor.Controller;

import com.yobombel.homesuppliesmonitor.Model.User;
import com.yobombel.homesuppliesmonitor.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
@RequiredArgsConstructor
public class UserAPI {

    private final UserService userService;

    @PostMapping("new")
    public void createNewUser(@RequestBody User user){
        userService.createNewUser(user);
    }

    @GetMapping("all")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

}