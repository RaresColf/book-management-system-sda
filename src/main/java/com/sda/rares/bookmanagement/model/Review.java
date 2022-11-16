package com.sda.rares.bookmanagement.model;

import javax.persistence.*;

@Entity
@Table (name = "book_review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column (name = "score")
    private Integer score;
    @Column (name = "comment")
    private String comment;

    public Review(Integer score, String comment) {
        this.score = score;
        this.comment = comment;
    }

    @ManyToOne
    @JoinColumn (name = "book_id")
    public Book book;

    public Review() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                '}';
    }
}
