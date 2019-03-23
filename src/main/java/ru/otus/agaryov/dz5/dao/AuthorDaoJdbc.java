package ru.otus.agaryov.dz5.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.otus.agaryov.dz5.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private final JdbcOperations jdbc;

    public AuthorDaoJdbc(JdbcOperations jdbcOperations) {
        jdbc = jdbcOperations;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(*) from authors", Integer.class);
    }

    @Override
    public void insert(Author author) {
        jdbc.update("insert into authors (id, `name`) values (?, ?)", author.getId(), author.getName());
    }

    @Override
    public Author getById(int id) {
        return jdbc.queryForObject("select * from authors where id = ?", new Object[] {id}, new PersonMapper());
    }

    @Override
    public List<Author> getAll() {
        return jdbc.queryForList("select * from authors", Author.class, new PersonMapper());
    }

    private static class PersonMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            return new Author(id, name);
        }
    }
}
