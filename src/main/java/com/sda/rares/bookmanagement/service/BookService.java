package com.sda.rares.bookmanagement.service;

import com.sda.rares.bookmanagement.model.Book;
import com.sda.rares.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.rares.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.List;

public interface BookService {

    void createBook(String title, String description, int authorid) throws EntityNotFoundException, InvalidParameterException;

    List<Book>  getAllBooks();

}
