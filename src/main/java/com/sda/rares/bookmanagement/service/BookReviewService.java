package com.sda.rares.bookmanagement.service;

import com.sda.rares.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.rares.bookmanagement.service.exceptions.InvalidParameterException;

public interface BookReviewService {

    void createBookReview(String bookTitle, int score, String comment) throws InvalidParameterException, EntityNotFoundException;
}
