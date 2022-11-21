package com.sda.rares.bookmanagement.controller;

import com.sda.rares.bookmanagement.service.BookReviewService;
import com.sda.rares.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.rares.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.Scanner;

public class ReviewController {

    private final Scanner scanner = new Scanner(System.in);
    private final BookReviewService bookReviewService;

    public ReviewController(BookReviewService bookReviewService) {
        this.bookReviewService = bookReviewService;
    }

    public void createReview(){
        try {
        System.out.println("Please insert book title ");
        String title = scanner.nextLine();
        System.out.println("Plsease insert a score ");
        int score = Integer.parseInt(scanner.nextLine());
        System.out.println("Please insert a comment ");
        String comment = scanner.nextLine();


            bookReviewService.createBookReview(title, score, comment);
        } catch (NumberFormatException e) {
            System.out.println(" Plsease insert a numeric value for score ");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(" Internal system error ");
        }
    }
}
