package com.sda.rares.bookmanagement;

import com.sda.rares.bookmanagement.controller.AuthorController;
import com.sda.rares.bookmanagement.controller.BookController;
import com.sda.rares.bookmanagement.controller.ReviewController;
import com.sda.rares.bookmanagement.menu.UserOption;
import com.sda.rares.bookmanagement.model.Review;
import com.sda.rares.bookmanagement.repository.AuthorRepositoryImpl;
import com.sda.rares.bookmanagement.repository.BookRepositoryImpl;
import com.sda.rares.bookmanagement.repository.BookReviewRepository;
import com.sda.rares.bookmanagement.repository.BookReviewRepositoryImpl;
import com.sda.rares.bookmanagement.service.AuthorServiceImpl;
import com.sda.rares.bookmanagement.service.BookReviewServiceImpl;
import com.sda.rares.bookmanagement.service.BookServiceImpl;
import com.sda.rares.bookmanagement.utils.SessionManager;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionManager.getSessionFactory();  // fortam pornirea Hibernate fara a avea un repository
        Scanner scanner = new Scanner(System.in);
        AuthorController authorController = new AuthorController(new AuthorServiceImpl(new AuthorRepositoryImpl()));
        BookController bookController = new BookController(new BookServiceImpl(new BookRepositoryImpl(),new AuthorRepositoryImpl()));
        ReviewController reviewController = new ReviewController(new BookReviewServiceImpl(new BookRepositoryImpl(),new BookReviewRepositoryImpl()));


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
                case UPDATEAUTHOR:
                    authorController.updateAuthor();
                    break;
                case DELETEAUTHOR:
                    authorController.deleteAuthor();
                    break;
                case CREATEBOOK:
                    bookController.createBook();
                    break;
                case SHOWALLBOOKS:
                    bookController.showAllBooks();
                    break;
                case CREATE_REVIEW:
                    reviewController.createReview();
                    break;
                case IMPORT_AUTHORS:
                    authorController.importAuthors();
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
