package com.example.BookStore.service;

import com.example.BookStore.dao.UserRepository;
import com.example.BookStore.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theuserRepository){
        this.userRepository = theuserRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(String userId){
        return userRepository.findByUserId(userId);
    }

    @Transactional
    public User save(User user){
        return userRepository.save(user);

    }

    @Transactional
    public void deleteById(String userId){
        User user = userRepository.findByUserId(userId).orElseThrow(()-> new RuntimeException("User not found"));
// check this
        userRepository.deleteByUserId(userId);
    }
}
