package com.rasysbox.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void executeQuery() {
        String sql = "SELECT * FROM my_table";
        jdbcTemplate.query(sql, (rs, rowNum) -> {
            // Procesar resultados de la consulta
            // rs.getString("column_name");
            return null;
        });
    }

}
