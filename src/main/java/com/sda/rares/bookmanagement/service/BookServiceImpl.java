package com.sda.rares.bookmanagement.service;

import com.sda.rares.bookmanagement.model.Author;
import com.sda.rares.bookmanagement.model.Book;
import com.sda.rares.bookmanagement.repository.AuthorRepository;
import com.sda.rares.bookmanagement.repository.BookRepository;
import com.sda.rares.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.rares.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public void createBook(String title, String description, int authorId) throws EntityNotFoundException, InvalidParameterException {
        // bookserviceimpl va lucra si cu authorid repository deoarece vrem sa validam daca exista un anumit autorid si bookrepository nu stie sa faca asta

        if (title == null || title.isBlank() || title.length() < 3) {
            throw new InvalidParameterException("Provided value for title: " + title + " is invalid");
        }
        if (description == null || description.isBlank() || description.length() < 10) {
            throw new InvalidParameterException("Provided value for description: " + description + " is invalid");
        }
        if (authorId < 1 ){
            throw new InvalidParameterException("Provided value for author id: " + authorId + " is invalid");
        }
        Optional<Author> authorOptional  = authorRepository.findById(authorId);
        if (authorOptional.isEmpty()) {
            throw new EntityNotFoundException("Author with provided id " + authorId + " was not found ");
        }

        Author author = authorOptional.get();
        Book book = new Book(title,description);
        book.setAuthor(author);       // aici se seteaza autorul cartii, se foloseste seterul pentru relatii

        bookRepository.create(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
