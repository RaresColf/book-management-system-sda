package com.sda.rares.bookmanagement.utils;


import com.sda.rares.bookmanagement.model.Author;
import com.sda.rares.bookmanagement.model.Book;
import com.sda.rares.bookmanagement.model.Review;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Trebuie sa ne asiguram ca aceasta clasa are un pattern de Singleton
 *     - Constructorul in patternul Sigleton trebuie sa fie private ca sa putem controla de cate ori il instantiem
 *     - Instantiem " private static final SessionManager INSTANCE  = new SessionManager(); " si o facem constanta si o facem sa fie una singura prin Static,
 *        si vrem sa fie si final ca sa nu o putem modifica
 *      - cel mai simplu mod de a face o constanta.
 *      CRUD = create, read, update, delete.
 */

public class SessionManager extends AbstractSessionManager {

    private static final SessionManager INSTANCE  = new SessionManager();

    private SessionManager(){
    }

    public static SessionFactory getSessionFactory(){
        return INSTANCE.getSessionFactory("book_management_system");
    }

    public static void shutDown(){
        INSTANCE.shutdownSessionManager();
    }


    @Override
    protected void setAnnotatedClasses(Configuration configuration) {
        //Hibernate model will be added here
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Review.class);
    }
}
