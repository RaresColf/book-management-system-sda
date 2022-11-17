package com.sda.rares.bookmanagement.repository;

import com.sda.rares.bookmanagement.model.Author;

public class AuthorRepositoryImpl extends BaseRepositoryImpl<Author> implements AuthorRepository {

    public AuthorRepositoryImpl() {
        super(Author.class);
    }
}
