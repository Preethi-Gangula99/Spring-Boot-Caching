package com.example.cache_practice.controllers;

import com.example.cache_practice.entities.Book;
import com.example.cache_practice.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BooksService booksService;

    @PostMapping("/save")
    public ResponseEntity<String> saveBook(@RequestBody() Book book){
        String result = booksService.saveBook(book);
      return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @GetMapping("/get/books/{id}")
    public ResponseEntity<Book>  getBooks(@PathVariable("id") Long id){
        Book booksList = booksService.getBooks(id);
        return new ResponseEntity<>(booksList, HttpStatus.OK);
    }

    @PutMapping("/update/book")
    public ResponseEntity<Book> updateBook(@RequestBody() Book book){
       Book updatedBook = booksService.updateBook(book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/delete/book/{id}")
    public String deleteBook(@PathVariable Long id) throws Exception {
        booksService.deleteBook(id);
        return "Book has been deleted successfully";
    }

}
