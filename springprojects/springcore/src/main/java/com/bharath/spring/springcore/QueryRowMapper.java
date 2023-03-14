package com.bharath.spring.springcore;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryRowMapper implements RowMapper<QueryObject> {

    @Override
    public QueryObject mapRow(ResultSet resultSet, int i) throws SQLException {
        QueryObject row= new QueryObject();
        row.setId(resultSet.getInt(1));
        row.setDatasource(resultSet.getInt(2));
        row.setQuerylanguage(resultSet.getString(3));
        row.setSqlquery(resultSet.getString(4));
        return row;
    }
}
