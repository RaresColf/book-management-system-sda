package com.sda.rares.bookmanagement.repository;

import com.sda.rares.bookmanagement.model.Book;
import com.sda.rares.bookmanagement.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book> implements BookRepository {
    public BookRepositoryImpl() {
        super(Book.class);     // entityClass scoatem si punem Book.class deoarece stiim ca book este entity class cu care lucreaza repository
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            Query<Book> bookQuery = session.createQuery("FROM Book b WHERE b.title = : bookTitle", Book.class);
            bookQuery.setParameter("bookTitle", title);
            List<Book> books = bookQuery.list();
            if (!books.isEmpty()) {
                return Optional.of(books.get(0));   // returnez o lista si consider ca returneaza un singur element de fiecare data si get(o) returneaza primul element din lista
            } else {
                return Optional.empty();
            }
        }

    }
}