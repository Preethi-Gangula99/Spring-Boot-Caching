package com.example.cache_practice.repositories;

import com.example.cache_practice.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Book,Long> {

    Optional<List<Book>> findByName(@Param("name") String name);

}
