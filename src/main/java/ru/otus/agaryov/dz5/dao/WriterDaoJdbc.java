package ru.otus.agaryov.dz5.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.otus.agaryov.dz5.domain.Writer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class WriterDaoJdbc implements WriterDao {

    private final JdbcOperations jdbc;

    public WriterDaoJdbc(JdbcOperations jdbcOperations) {
        jdbc = jdbcOperations;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(*) from writers", Integer.class);
    }

    @Override
    public void insert(Writer writer) {
        jdbc.update("insert into writers (id, name) values (?, ?)", writer.getId(), writer.getName());
    }

    @Override
    public Writer getById(int id) {
        return jdbc.queryForObject("select * from writers where id = ?", new Object[] {id}, new WriterMapper());
    }

    @Override
    public List<Writer> getAll() {
        return jdbc.queryForList("select * from writers", Writer.class, new WriterMapper());
    }

    private static class WriterMapper implements RowMapper<Writer> {

        @Override
        public Writer mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            return new Writer(id, name);
        }
    }
}
