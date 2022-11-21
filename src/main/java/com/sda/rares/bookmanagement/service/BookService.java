package com.sda.rares.bookmanagement.service;

import com.sda.rares.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.rares.bookmanagement.service.exceptions.InvalidParameterException;

public interface BookService {

    void createBook(String title, String description, int authorid) throws EntityNotFoundException, InvalidParameterException;

}
