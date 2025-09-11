package org.example.mappers.impl;

import org.example.mappers.RowMapper;
import org.example.model.Post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostMapper implements RowMapper<Post> {
    @Override
    public Post mapRow(ResultSet rs) throws SQLException {
        Post post = new Post();
        post.setId(rs.getLong(1));
        post.setContent(rs.getString(2));
        post.setCreated(rs.getTimestamp(3).toInstant());
        post.setUpdated(rs.getTimestamp(4).toInstant());
        post.setLabels(new ArrayList<>());
        post.setWriterId(rs.getLong(5));
        return post;
    }
}
