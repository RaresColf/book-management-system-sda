package com.sda.rares.bookmanagement.repository;

import com.sda.rares.bookmanagement.model.Book;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book> implements BookRepository{
    public BookRepositoryImpl() {
        super(Book.class);     // entityClass scoatem si punem Book.class deoarece stiim ca book este entity class cu care lucreaza repository
    }
}
