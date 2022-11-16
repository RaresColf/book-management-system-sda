package com.sda.rares.bookmanagement;

import com.sda.rares.bookmanagement.utils.SessionManager;

public class Main {
    public static void main(String[] args) {
        SessionManager.getSessionFactory();  // fortam pornirea Hibernate fara a avea un repository
    }
}
