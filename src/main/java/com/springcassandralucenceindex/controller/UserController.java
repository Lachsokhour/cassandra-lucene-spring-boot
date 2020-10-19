package com.springcassandralucenceindex.controller;

import com.springcassandralucenceindex.model.User;
import com.springcassandralucenceindex.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/findByName/{fieldName}/{search}")
    public List<User> findByName(@PathVariable String fieldName, @PathVariable String search){

        return userService.findAllByFilter(fieldName,search);
    }

    @GetMapping("/sortUserByField/{fieldName}/{order}")
    public ResponseEntity<List<User>> sortUserByField(@PathVariable String fieldName, @PathVariable String order){
        return userService.sortUserByField(fieldName,order);
    }

    @GetMapping("/test")
    public List<User> test(){
        return userService.test();
    }

}
