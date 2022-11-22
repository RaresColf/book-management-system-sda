package com.sda.rares.bookmanagement.service;

import com.sda.rares.bookmanagement.model.Author;
import com.sda.rares.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.rares.bookmanagement.service.exceptions.InvalidParameterException;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void createAuthor(String firstName, String lastName) throws InvalidParameterException;

    void updateAuthor(int authorid, String firstName, String lastName) throws InvalidParameterException, EntityNotFoundException;

    void deleteAuthor(int authorId) throws InvalidParameterException, EntityNotFoundException;

    void importAuthors() throws IOException;

    List<Author> getAllAuthors();

}
