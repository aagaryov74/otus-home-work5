package ru.otus.agaryov.dz5;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.agaryov.dz5.dao.GenreDao;
import ru.otus.agaryov.dz5.dao.WriterDao;
import ru.otus.agaryov.dz5.domain.Writer;

import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = SpringApplication.run(Main.class);
        WriterDao wDao = context.getBean(WriterDao.class);

        GenreDao gDao = context.getBean(GenreDao.class);

        System.out.println("All count " + wDao.count());

        wDao.insert(new Writer(3, "Л. Н. Толстой"));

        System.out.println(gDao.insertByName("Пьеса"));

        System.out.println("All count " + wDao.count());

        Writer ivan = wDao.getById(2);

        System.out.println(wDao.getAll());

        System.out.println("Ivan id: " + ivan.getId() + " name: " + ivan.getName());

        Console.main(args);
    }
}
