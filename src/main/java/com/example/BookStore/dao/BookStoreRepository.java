package com.example.BookStore.dao;

import com.example.BookStore.entity.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookStoreRepository extends JpaRepository<BookStore,Integer> {
    Optional<BookStore> findByBookId(String bookId);
    void deleteByBookId(String bookId);
}
