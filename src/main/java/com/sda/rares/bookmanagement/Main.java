package com.sda.rares.bookmanagement;

import com.sda.rares.bookmanagement.controller.AuthorController;
import com.sda.rares.bookmanagement.menu.UserOption;
import com.sda.rares.bookmanagement.repository.AuthorRepositoryImpl;
import com.sda.rares.bookmanagement.service.AuthorServiceImpl;
import com.sda.rares.bookmanagement.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionManager.getSessionFactory();  // fortam pornirea Hibernate fara a avea un repository
        Scanner scanner = new Scanner(System.in);
        AuthorController authorController = new AuthorController(new AuthorServiceImpl(new AuthorRepositoryImpl()));


        UserOption userOption;
        do {
            UserOption.printAllOptions();
            System.out.println("Please select an option");
            try {
                int numericOption = Integer.parseInt(scanner.nextLine());
                userOption = UserOption.findUserOption(numericOption);
            } catch (NumberFormatException e) {
                userOption = UserOption.UNKNOWN;
            }

            switch (userOption) {
                case CREATE_AUTHOR :
//                  System.out.println("Not implemented yet");   // am autorul creeat asa ca renunt la mesajul ca nu e implementat
                    authorController.createAuthor();        // am creeat autorul
                    break;
                case SHOWALLAUTHORS:
                    authorController.showAllAuthors();  // am apleat controllerul cu metoda showAll
                    break;

                case EXIT:
                    System.out.println("Goodbye");
                    break;

                case UNKNOWN:
                    System.out.println("Option unknown");
                    break;

                default:
                    System.out.println("User option " + userOption + " is not implemented ");
                    break;
            }

        } while (userOption != UserOption.EXIT);

        SessionManager.shutDown();
    }

}
