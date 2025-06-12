package com.example.BookStore.rest;

import com.example.BookStore.entity.BookStore;
import com.example.BookStore.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@CrossOrigin
public class BookStoreRestController {

    private BookStoreService bookStoreService;

    @Autowired
    public BookStoreRestController(BookStoreService theBookStoreService){
        bookStoreService = theBookStoreService;
    }

    @GetMapping("/")
    public List<BookStore> findAll(){
        return bookStoreService.findAll();
    }

    @GetMapping("/api/get-books/{findId}")
    public Optional<BookStore> findById(int theId){
        Optional<BookStore> findId = bookStoreService.findById(theId);

        if(findId == null){
            throw new RuntimeException("ID not found");
        }
        return findId;
    }

    @PostMapping("/books")
    public BookStore addNewBook(@RequestBody BookStore bookStore){
        bookStore.setId(0);
        BookStore dBook = bookStoreService.save(bookStore);
        return dBook;
    }

    @PutMapping("/api/add-books")
    public BookStore updateBook(@RequestBody BookStore bookStore){
        return bookStoreService.save(bookStore);
    }

    @DeleteMapping("/api/delete-book/{theId}")
    public void deleteById(@PathVariable int theId){
        bookStoreService.deleteById(theId);
    }
}
