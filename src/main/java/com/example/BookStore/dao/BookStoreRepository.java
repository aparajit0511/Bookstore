package com.example.BookStore.dao;

import com.example.BookStore.entity.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStoreRepository extends JpaRepository<BookStore,Integer> {

}
