package com.example.BookStore.dao;

import com.example.BookStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
Optional<User> findByUserId(String userId);
void deleteByUserId(String userId);

}
