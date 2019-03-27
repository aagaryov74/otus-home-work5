package ru.otus.agaryov.dz5.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.agaryov.dz5.domain.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GenreDaoJdbc implements GenreDao {

    private final JdbcOperations jdbc;

    public GenreDaoJdbc(JdbcOperations jdbcOperations) {
        jdbc = jdbcOperations;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(id) from genre", Integer.class);
    }

    @Override
    public void insert(Genre genre) {
        jdbc.update("insert into genres (id, name) values (?, ?)", genre.getId(), genre.getName());
    }
    @Override
    public Number insertByName(String name) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(
                                "insert into genres (name) values(?)", new String[] {"id"});
                        ps.setString(1, name);
                        return ps;
                    }
                },
                keyHolder);
        return keyHolder.getKey();
    }

    @Override
    public Genre getById(int id) {
        return jdbc.queryForObject("select * from genres where id = ?", new Object[] {id}, new GenreMapper());
    }

    @Override
    public List<Genre> getAll() {
        return jdbc.queryForList("select *" +
                " from genres", Genre.class, new GenreMapper());
    }

    private static class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            return new Genre(id, name);
        }
    }
}
