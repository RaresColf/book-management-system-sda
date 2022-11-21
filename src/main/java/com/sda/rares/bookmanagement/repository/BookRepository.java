package com.sda.rares.bookmanagement.repository;

import com.sda.rares.bookmanagement.model.Book;
import com.sda.rares.bookmanagement.model.Review;

import java.util.Optional;

public interface BookRepository extends BaseRepository<Book>{
    Optional<Book> findByTitle(String title);
}
