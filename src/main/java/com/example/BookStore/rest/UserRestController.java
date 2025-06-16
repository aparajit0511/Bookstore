package com.example.BookStore.rest;


import com.example.BookStore.entity.User;
import com.example.BookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
@CrossOrigin
public class UserRestController {
    public UserService userService;

    @Autowired
    public UserRestController(UserService theuserService){
        this.userService = theuserService;
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/api/get-users/{userId}")
    public Optional<User> findById(@PathVariable String userId){

        Optional<User> findUserId = userService.findById(userId);
        if(findUserId == null){
            throw new RuntimeException("ID not found");
        }

        return findUserId;
    }

    @PostMapping("/api/add-users")
    public User addNewUsers(@RequestBody User user){
        user.setUserId(UUID.randomUUID().toString());
        return userService.save(user);
    }

    @PutMapping("/api/add-users")
    public User updateUsers(@RequestBody User incomingUser){
        User existingUser = userService.findById(incomingUser.getUserId()).orElseThrow(()-> new RuntimeException("Book with ID " + incomingUser.getUserId() + " not found"));

        existingUser.setUserName(incomingUser.getUserName());
        existingUser.setEmail(incomingUser.getEmail());
        return userService.save(existingUser);
    }

    @DeleteMapping("/api/delete-user/{userId}")
    public void deleteById(@PathVariable String userId){
        userService.deleteById(userId);
    }

}
