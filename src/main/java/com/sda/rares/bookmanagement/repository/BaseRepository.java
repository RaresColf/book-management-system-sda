package com.sda.rares.bookmanagement.repository;

import com.sda.rares.bookmanagement.model.Author;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {
    Optional<T> findById(Integer id);

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    List<T> findAll();

}