package org.example.mappers.impl;

import org.example.mappers.RowMapper;
import org.example.model.Label;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LabelMapper implements RowMapper<Label> {
    @Override
    public Label mapRow(ResultSet rs) throws SQLException {
        Label label = new Label();
        label.setId(rs.getLong(1));
        label.setName(rs.getString(2));

        return label;
    }
}
