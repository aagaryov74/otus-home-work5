package ru.otus.agaryov.dz5.dao;


import ru.otus.agaryov.dz5.domain.Book;
import ru.otus.agaryov.dz5.domain.Genre;

import java.util.List;

public interface GenreDao {

    int count();

    void insert(Genre genre);

    Number insertByName(String name);

    Genre getById(int id);

    List<Genre> getAll();
}
