package ru.otus.agaryov.dz5.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.agaryov.dz5.domain.Writer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class WriterDaoJdbc implements WriterDao {

    private final NamedParameterJdbcOperations namedJdbcOperations;
    private final JdbcOperations jdbcOperations;
    private final KeyHolder keyHolder;

    public WriterDaoJdbc(NamedParameterJdbcOperations jdbcOperations, JdbcOperations jdbcOperations1) {
        this.namedJdbcOperations = jdbcOperations;
        this.jdbcOperations = jdbcOperations1;
        this.keyHolder = new GeneratedKeyHolder();
    }

    @Override
    public int count() {
        return namedJdbcOperations.queryForObject("select count(id) from writers",(Map) null, Integer.class);
    }

    @Override
    public void insert(Writer writer) {
        final Map<String,Object> params = new HashMap<>();
        params.put("id", writer.getId());
        params.put("name",writer.getName());
        namedJdbcOperations.update("insert into writers (id, name) values (:id, :name)", params);
    }

    @Override
    public Number insertByName(String name) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(
                                "insert into writers (name) values(?)", new String[] {"id"});
                        ps.setString(1, name);
                        return ps;
                    }
                },
                keyHolder);
        return keyHolder.getKey();
    }

    @Override
    public Writer getById(int id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("id",id);
        return namedJdbcOperations.queryForObject("select * from writers where id = :id",
                parameterSource, new WriterMapper());
    }

    @Override
    public List<Writer> getAll() {
        return namedJdbcOperations.query("select * from writers",new WriterMapper());
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
