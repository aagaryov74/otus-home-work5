package ru.otus.agaryov.dz5;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@DisplayName("Тесты классов программы для хранения книг в библиотеке")
@RunWith(SpringRunner.class)
@JdbcTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@SpringBootTest
class DZtest {


    private EmbeddedDatabase embeddedDatabase;

    private JdbcTemplate jdbcTemplate;

    @DisplayName("Создадим базу данных для тестирования")
    @Before
    public void setUp() {
        embeddedDatabase = new EmbeddedDatabaseBuilder()
                .addDefaultScripts()// Добавляем скрипты schema.sql и data.sql
                .setType(EmbeddedDatabaseType.H2)// Используем базу H2
                .build();

        // Создадим JdbcTemplate
        jdbcTemplate = new JdbcTemplate(embeddedDatabase);

    }

    @DisplayName("Тестируем бины")
    @Test
    void testBeans() {

    }


    @After
    public void tearDown() {
        embeddedDatabase.shutdown();
    }



}
