package com.sda.rares.bookmanagement.service;

import com.sda.rares.bookmanagement.model.Author;
import com.sda.rares.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.List;

public interface AuthorService {
    void createAuthor(String firstName, String lastName) throws InvalidParameterException;

    List<Author> getAllAuthors();

}
