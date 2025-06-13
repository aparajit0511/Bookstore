package com.example.BookStore.service;


import com.example.BookStore.dao.BookStoreRepository;
import com.example.BookStore.entity.BookStore;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookStoreServiceImpl implements BookStoreService {

    private BookStoreRepository bookStoreRepository;

    @Autowired
    public BookStoreServiceImpl(BookStoreRepository theBookStoreRepository){
        bookStoreRepository = theBookStoreRepository;
    }

    public List<BookStore> findAll(){
        return bookStoreRepository.findAll();
    }

    @Transactional
    public BookStore save(BookStore bookStore){
        return bookStoreRepository.save(bookStore);
    }

    @Transactional
    public void deleteById(String bookId){
        bookStoreRepository.deleteByBookId(bookId);
    }

    public Optional<BookStore> findById(String bookId){

        return bookStoreRepository.findByBookId(bookId);
    }

}
