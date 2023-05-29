package com.rasysbox.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class MyRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String executeQuery(String msisdn) {
        String sql = "SELECT a.msisdn, b.ido AS ido_receiver " +
                "FROM spnv_col.spn_numeration a " +
                "JOIN spnv_col.spn_operator b ON a.receiverop = b.operatorid " +
                "JOIN spnv_col.spn_operator c ON a.donorop = c.operatorid " +
                "JOIN spnv_col.spn_operator d ON a.ownerop = d.operatorid " +
                "WHERE a.msisdn = :msisdn";
        StringBuilder result = new StringBuilder();
        jdbcTemplate.query(sql, new ResultSetExtractor<Void>() {
            @Override
            public Void extractData(ResultSet rs) throws SQLException {
                while (rs.next()) {
                    String msisdnValue = rs.getString("msisdn");
                    String idoValue = rs.getString("ido_receiver");

                    result.append("msisdn: ").append(msisdnValue)
                            .append(", ido_receiver: ").append(idoValue)
                            .append("\n");
                }
                return null;
            }
        }, msisdn);

        return result.toString();
    }

}
