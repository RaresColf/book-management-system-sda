package com.sda.rares.bookmanagement.service;

import com.sda.rares.bookmanagement.service.exceptions.InvalidParameterException;

public interface AuthorService {
    void createAuthor(String firstName, String lastName) throws InvalidParameterException;
}
