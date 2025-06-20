package com.example.BookStore.rest;

import com.example.BookStore.entity.BookStore;
import com.example.BookStore.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/api/get-books/{bookId}")
    public Optional<BookStore> findById(@PathVariable String bookId){
        Optional<BookStore> findId = bookStoreService.findById(bookId);

        if(findId == null){
            throw new RuntimeException("ID not found");
        }
        return findId;
    }

    @PostMapping("/api/add-books")
    public BookStore addNewBook(@RequestBody BookStore bookStore){
//        bookStore.setId(0);
//        BookStore dBook = bookStoreService.save(bookStore);
//        return dBook;
        bookStore.setBookId(UUID.randomUUID().toString());
        return bookStoreService.save(bookStore);
    }

    @PutMapping("/api/add-books")
    public BookStore updateBook(@RequestBody BookStore incomingBook) {
        // Step 1: Find existing book by bookId
        BookStore existingBook = bookStoreService.findById(incomingBook.getBookId())
                .orElseThrow(() -> new RuntimeException("Book with ID " + incomingBook.getBookId() + " not found"));

        // Step 2: Update fields (keep the same `id`)
        existingBook.setTitle(incomingBook.getTitle());
        existingBook.setAuthor(incomingBook.getAuthor());
        existingBook.setGenre(incomingBook.getGenre());
        existingBook.setPrice(incomingBook.getPrice());

        // Step 3: Save the updated book
        return bookStoreService.save(existingBook);
    }


    @DeleteMapping("/api/delete-book/{bookId}")
    public void deleteById(@PathVariable String bookId){
        bookStoreService.deleteById(bookId);
    }
}
