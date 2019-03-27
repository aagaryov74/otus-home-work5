package ru.otus.agaryov.dz5.shell;

import ru.otus.agaryov.dz5.dao.GenreDao;
import ru.otus.agaryov.dz5.dao.WriterDao;
import ru.otus.agaryov.dz5.domain.Writer;



public class WorkWithBooks {
    private final WriterDao writerDao;
    private final GenreDao genreDao;

    public WorkWithBooks(WriterDao writerDao, GenreDao genreDao) {
        this.writerDao = writerDao;
        this.genreDao = genreDao;
    }
/*
    @ShellMethod("Insert a new book into the library")
    private void insertBook(@ShellOption @NotNull String genre,
                            @ShellOption @NotNull String writer) {


    }
*/
}
