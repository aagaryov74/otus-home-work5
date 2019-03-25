package ru.otus.agaryov.dz5.domain;

public class Writer {

    private final int id;
    private final String name;

    public Writer(int id, String name) {
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
