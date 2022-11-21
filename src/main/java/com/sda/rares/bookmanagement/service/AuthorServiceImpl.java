package com.sda.rares.bookmanagement.service;

import com.sda.rares.bookmanagement.model.Author;
import com.sda.rares.bookmanagement.repository.AuthorRepository;
import com.sda.rares.bookmanagement.service.AuthorService;
import com.sda.rares.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.rares.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.List;
import java.util.Optional;

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

        authorRepository.create(new Author(firstName,lastName));  // am creeat autorul prin new Author prin care am dat parametrii first si last name, si am dat cu new deoarece autorul nu a avut nici o relatie
    }

    @Override
    public void updateAuthor(int authorId, String firstName, String lastName) throws InvalidParameterException, EntityNotFoundException {

        if (authorId < 1 ){
            throw new InvalidParameterException("Provided value for author id: " + authorId + " is invalid");
        }

        if (firstName == null || firstName.isBlank() || firstName.length() < 3) {
            throw new InvalidParameterException("Provided value for first name: " + firstName + " is invalid");
        }

        if (lastName == null || lastName.isBlank() || lastName.length() < 3) {
            throw new InvalidParameterException("Provided value for last name: " + lastName + " is invalid");
        }

        Optional<Author> authorOptional = authorRepository.findById(authorId);     // caut in baza de date autorul in functie de authorId sa vad daca exista
        if (authorOptional.isEmpty()) {
            throw new EntityNotFoundException("Author with id " + authorId + "not found");
        }
        Author author = authorOptional.get();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.update(author);
    }

    @Override
    public void deleteAuthor(int authorId) throws InvalidParameterException, EntityNotFoundException {
        if (authorId < 1 ){
            throw new InvalidParameterException("Provided value for author id: " + authorId + " is invalid");
        }
        Optional<Author> authorOptional = authorRepository.findById(authorId);     // caut in baza de date autorul in functie de authorId sa vad daca exista
        if (authorOptional.isEmpty()) {
            throw new EntityNotFoundException("Author with id " + authorId + "not found");
        }
        Author author = authorOptional.get();

        authorRepository.delete(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();   // returnam din repository metoda findAll
    }
}
