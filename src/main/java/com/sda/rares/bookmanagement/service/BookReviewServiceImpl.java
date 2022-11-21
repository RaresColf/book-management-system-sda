package com.sda.rares.bookmanagement.service;

import com.sda.rares.bookmanagement.model.Book;
import com.sda.rares.bookmanagement.model.Review;
import com.sda.rares.bookmanagement.repository.BookRepository;
import com.sda.rares.bookmanagement.repository.BookReviewRepository;
import com.sda.rares.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.rares.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.Optional;

public class BookReviewServiceImpl implements BookReviewService {
    private final BookRepository bookRepository;   // avem nevoie pentru a adauga un nume de carte
    private final BookReviewRepository bookReviewRepository;  // avem nevoie pentru a crea un comment

    public BookReviewServiceImpl(BookRepository bookRepository, BookReviewRepository bookReviewRepository) {
        this.bookRepository = bookRepository;
        this.bookReviewRepository = bookReviewRepository;
    }


    @Override
    public void createBookReview(String bookTitle, int score, String comment) throws InvalidParameterException, EntityNotFoundException {
        if (bookTitle == null || bookTitle.isBlank() || bookTitle.length() < 3) {
            throw new InvalidParameterException("Provided value for book title: " + bookTitle + " is invalid");
        }
        if (comment == null || comment.isBlank() || comment.length() < 10) {
            throw new InvalidParameterException("Provided value for comment: " + comment + " is invalid");
        }
        if (score < 1 || score > 5) {
            throw new InvalidParameterException("Provided value for score: " + score + " is invalid");
        }

        Optional<Book> bookOptional = bookRepository.findByTitle(bookTitle);
        if (bookOptional.isEmpty()) {
            throw new EntityNotFoundException(" Book not found for title " + bookTitle);
        }
        Book book = bookOptional.get() ;// am trecut de pasul in care se verifica daca exista cartea pentru care vrem sa lasam un review si incep sa despachetez optionalul de mai sus
        Review review = new Review(score, comment);
        review.setBook(book);

        bookReviewRepository.create(review);
    }
}
