package org.example.repository.impl;

import org.example.mappers.RowMapper;
import org.example.mappers.impl.LabelMapper;
import org.example.mappers.impl.PostMapper;
import org.example.model.Label;
import org.example.model.Post;
import org.example.model.PostStatus;
import org.example.repository.PostRepository;
import org.example.utils.ConnectionManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    @Override
    public Long createPost(Post post) {
        try {
            var connection = ConnectionManager.getConnection();

            String postSql = """
                    INSERT INTO posts (content, writerId)
                    VALUES (?,?)
                    """;

            var postStatement = connection.prepareStatement(postSql, Statement.RETURN_GENERATED_KEYS);
            postStatement.setString(1, post.getContent());
            postStatement.setLong(2, post.getWriterId());
            postStatement.executeUpdate();

            var generatedKeys = postStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                String statusSql = """
                        INSERT INTO post_status (id, status)
                        VALUES (?,?)
                        """;
                long id = generatedKeys.getLong(1);

                var statusStatement = connection.prepareStatement(statusSql);
                statusStatement.setLong(1, id);
                statusStatement.setString(2, post.getStatus().getStatus());
                statusStatement.executeUpdate();

                return id;
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Post getPostById(Long postId) {
        try {
            var connection = ConnectionManager.getConnection();

            String postSql = """
                    SELECT posts.id, content, created, updated, writerId, post_status.status
                    FROM posts
                    JOIN post_status ON posts.id = post_status.id
                    WHERE posts.id = ?
                    """;
            var postStatement = connection.prepareStatement(postSql);
            postStatement.setLong(1, postId);

            var result = postStatement.executeQuery();

            if (result.next()) {
                Post post = new PostMapper().mapRow(result);

                PostStatus postStatus = new PostStatus();
                postStatus.setId(result.getLong(1));
                postStatus.setStatus(result.getString(6));
                post.setStatus(postStatus);

                String labelsSql = """
                        SELECT * FROM labels
                        JOIN posts_labels ON labels.id = posts_labels.label_id
                        WHERE posts_labels.post_id = ?
                        """;
                var labelsStatement = connection.prepareStatement(labelsSql);
                labelsStatement.setLong(1, postId);
                var labelsResult = labelsStatement.executeQuery();

                RowMapper<Label> labelMapper = new LabelMapper();
                while (labelsResult.next()) {
                    Label label = labelMapper.mapRow(labelsResult);
                    post.getLabels().add(label);
                }

                return post;
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            var connection = ConnectionManager.getConnection();

            String sql = """
                    DELETE FROM posts
                    WHERE id = ?
                    """;
            var postStatement = connection.prepareStatement(sql);
            postStatement.setLong(1, id);

            var result = postStatement.executeUpdate();

            return result > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updatePost(Long id, String content) {
        try {
            var connection = ConnectionManager.getConnection();

            String sql = """
                    UPDATE posts
                    SET content = ?
                    WHERE id = ?
                    """;
            var postStatement = connection.prepareStatement(sql);
            postStatement.setString(1, content);
            postStatement.setLong(2, id);

            var result = postStatement.executeUpdate();

            return result > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
