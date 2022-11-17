package com.sda.rares.bookmanagement.controller;

import com.sda.rares.bookmanagement.model.Author;
import com.sda.rares.bookmanagement.service.AuthorService;
import com.sda.rares.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.Scanner;

public class AuthorController {

    private final AuthorService authorService;
    private final Scanner scanner = new Scanner(System.in);

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    public void createAuthor(){
        try {
        System.out.println("Please insert author first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Please insert author last name ");
        String lastName = scanner.nextLine();

            authorService.createAuthor(firstName,lastName);
            System.out.println("Author has been created");
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex){
            System.out.println("Internal server error !");
        }
    }
}
