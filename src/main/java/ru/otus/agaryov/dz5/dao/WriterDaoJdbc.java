package ru.otus.agaryov.dz5.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.agaryov.dz5.domain.Writer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class WriterDaoJdbc implements WriterDao {

    private final NamedParameterJdbcOperations jdbc;

    public WriterDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        jdbc = jdbcOperations;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(id) from writers",(Map) null, Integer.class);
    }

    @Override
    public void insert(Writer writer) {
        final Map<String,Object> params = new HashMap<>();
        params.put("id", writer.getId());
        params.put("name",writer.getName());
        jdbc.update("insert into writers (id, name) values (:id, :name)", params);
    }

    @Override
    public Writer getById(int id) {
        Map<String,Object> params = new HashMap<>(1);
            params.put("id", id);
        return jdbc.queryForObject("select * from writers where id = :id",params, new WriterMapper());
    }

    @Override
    public List<Writer> getAll() {

        return jdbc.queryForList("select * from writers", (Map) null);
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
