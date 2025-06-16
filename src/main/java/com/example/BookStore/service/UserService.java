package com.example.BookStore.service;

import com.example.BookStore.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(String userId);
    List<User> findAll();
    void deleteById(String userId);
    User save(User user);
}
