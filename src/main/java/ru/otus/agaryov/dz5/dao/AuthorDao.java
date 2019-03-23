package ru.otus.agaryov.dz5.dao;

import ru.otus.agaryov.dz5.domain.Author;

import java.util.List;

public interface AuthorDao {

    int count();

    void insert(Author author);

    Author getById(int id);

    List<Author> getAll();
}
