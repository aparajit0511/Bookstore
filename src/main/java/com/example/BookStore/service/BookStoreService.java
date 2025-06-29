package com.example.BookStore.service;

import com.example.BookStore.entity.BookStore;

import java.util.List;
import java.util.Optional;

public interface BookStoreService {

    List<BookStore> findAll();
    BookStore save (BookStore bookStore);
    void deleteById(String bookId);
    Optional<BookStore> findById(String bookId);

}
