package ru.otus.agaryov.dz5.shell;


import com.sun.istack.internal.NotNull;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.agaryov.dz5.dao.WriterDao;
import ru.otus.agaryov.dz5.domain.Writer;


@ShellComponent
public class WorkWithWriters {
    private final WriterDao writerDao;


    public WorkWithWriters(WriterDao writerDao) {
        this.writerDao = writerDao;
    }

    @ShellMethod("Insert a new writer  into the Database")
    private void insertWriter(@ShellOption @NotNull String name) {
        System.out.println("Writer added with id = " + writerDao.insertByName(name));
    }

    @ShellMethod("Insert a new writer  into the Database")
    private void insertWriterById(@ShellOption @NotNull String name,
                                  @ShellOption @NotNull String writerId) {
    }

    @ShellMethod("Select all writers  from Database")
    private void selectAllWriters() {
        for (Writer writer : writerDao.getAll()
        ) {
            System.out.println("Writer id " + writer.getId() + " Name " + writer.getName());
        }

    }
}
