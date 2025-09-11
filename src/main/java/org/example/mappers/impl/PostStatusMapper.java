package org.example.mappers.impl;

import org.example.mappers.RowMapper;
import org.example.model.PostStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostStatusMapper implements RowMapper<PostStatus> {
    @Override
    public PostStatus mapRow(ResultSet rs) throws SQLException {
        PostStatus postStatus = new PostStatus();
        postStatus.setId(rs.getLong(1));
        postStatus.setStatus(rs.getString(2));
        return postStatus;
    }
}
