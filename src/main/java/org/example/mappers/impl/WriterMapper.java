package org.example.mappers.impl;

import org.example.mappers.RowMapper;
import org.example.model.Writer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WriterMapper implements RowMapper<Writer> {
    @Override
    public Writer mapRow(ResultSet rs) throws SQLException {
        Writer writer = new Writer();
        writer.setId(rs.getLong(1));
        writer.setFirstName(rs.getString(2));
        writer.setLastName(rs.getString(3));
        return writer;
    }
}
