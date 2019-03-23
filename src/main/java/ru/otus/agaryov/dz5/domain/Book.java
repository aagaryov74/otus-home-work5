package ru.otus.agaryov.dz5.domain;

public class Book {

    private final int id;
    private final String name;

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
