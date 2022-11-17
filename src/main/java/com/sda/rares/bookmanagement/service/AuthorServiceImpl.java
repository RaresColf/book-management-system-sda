package com.sda.rares.bookmanagement.service;

import com.sda.rares.bookmanagement.model.Author;
import com.sda.rares.bookmanagement.repository.AuthorRepository;
import com.sda.rares.bookmanagement.service.AuthorService;
import com.sda.rares.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void createAuthor(String firstName, String lastName) throws InvalidParameterException {
        if (firstName == null || firstName.isBlank() || firstName.length() < 3) {
        throw new InvalidParameterException("Provided value for first name: " + firstName + " is invalid");
        }

        if (lastName == null || lastName.isBlank() || lastName.length() < 3) {
            throw new InvalidParameterException("Provided value for last name: " + lastName + " is invalid");
        }

        authorRepository.create(new Author(firstName,lastName));  // am creeat autorul prin new Author prin care am dat parametrii first si last name
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();   // returnam din repository metoda findAll
    }
}
