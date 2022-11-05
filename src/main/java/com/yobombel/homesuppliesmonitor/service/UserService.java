package com.yobombel.homesuppliesmonitor.service;

import com.yobombel.homesuppliesmonitor.model.User;
import com.yobombel.homesuppliesmonitor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void createNewUser(User user){
        userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public void removeUserById(Long id){
        userRepository.deleteById(id);
    }

}