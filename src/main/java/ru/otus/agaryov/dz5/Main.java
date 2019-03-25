package ru.otus.agaryov.dz5;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.agaryov.dz5.dao.WriterDao;
import ru.otus.agaryov.dz5.domain.Writer;

import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = SpringApplication.run(Main.class);
        WriterDao dao = context.getBean(WriterDao.class);

        System.out.println("All count " + dao.count());

        dao.insert(new Writer(3, "Л. Н. Толстой"));

        System.out.println("All count " + dao.count());

        Writer ivan = dao.getById(2);

        System.out.println(dao.getAll());

        System.out.println("Ivan id: " + ivan.getId() + " name: " + ivan.getName());

        Console.main(args);
    }
}
