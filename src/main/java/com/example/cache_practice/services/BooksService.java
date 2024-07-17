package com.example.cache_practice.services;

import com.example.cache_practice.entities.Book;
import com.example.cache_practice.repositories.BooksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BooksService {
    public static Logger logger =  LoggerFactory.getLogger(BooksService.class);
    @Autowired
    private BooksRepository booksRepo;

    public String saveBook(Book book){
        logger.info("book is saved");
        booksRepo.save(book);
        return "Successfully saved";
    }

    @Cacheable(cacheNames = "books", key = "#id")
    public Book getBooks(Long id){
        Optional<Book> book = booksRepo.findById(id);
        logger.info("get books is called");
        return book.orElseGet(Book::new);
    }

    @CachePut(cacheNames = "books",key = "#book.id")
    public Book updateBook(Book book){
        logger.info("update books is called");
        Optional<Book> bookFromRepo = booksRepo.findById(book.getId());
        Book existingBook = bookFromRepo.orElse(new Book());
        existingBook.setName(book.getName());
        booksRepo.save(existingBook);
        return  existingBook;
    }

    @CacheEvict(cacheNames = "books",key = "#id")
    public void deleteBook(Long id) throws Exception {
        logger.info("delete books is called");
        Optional<Book> book = booksRepo.findById(id);
        book.orElseThrow(() ->new Exception("Book Does npt exist"));
        booksRepo.deleteById(id);
    }
}
