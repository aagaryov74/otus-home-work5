package ru.otus.agaryov.dz5.dao;


import ru.otus.agaryov.dz5.domain.Book;

import java.util.List;

public interface BookDao {

    int count();

    void insert(Book book);

    Book getById(int id);

    List<Book> getAll();
}
