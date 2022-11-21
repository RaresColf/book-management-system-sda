package com.sda.rares.bookmanagement.repository;

import com.sda.rares.bookmanagement.model.Review;

public class BookReviewRepositoryImpl extends BaseRepositoryImpl<Review> implements BookReviewRepository {
    public BookReviewRepositoryImpl() {
        super(Review.class);
    }
}
