package com.yobombel.homesuppliesmonitor.Service;

import com.yobombel.homesuppliesmonitor.Model.User;
import com.yobombel.homesuppliesmonitor.Repository.UserRepository;
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