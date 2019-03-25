package ru.otus.agaryov.dz5.dao;

import ru.otus.agaryov.dz5.domain.Writer;

import java.util.List;

public interface WriterDao {

    int count();

    void insert(Writer writer);

    Writer getById(int id);

    List getAll();
}
