package org.example.repository.impl;

import org.example.mappers.RowMapper;
import org.example.mappers.impl.PostStatusMapper;
import org.example.model.PostStatus;
import org.example.repository.PostStatusRepository;
import org.example.utils.ConnectionManager;

import java.sql.SQLException;

public class PostStatusRepositoryImpl implements PostStatusRepository {

    @Override
    public PostStatus getById(Long postId) {
        try {
            var connection = ConnectionManager.getConnection();

            String sql = """
                    SELECT id, status
                    FROM post_status
                    WHERE id = ?
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setLong(1, postId);

            var result = statement.executeQuery();

            RowMapper<PostStatus> mapper = new PostStatusMapper();
            if (result.next()) {
                return mapper.mapRow(result);
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updatePostStatus(Long postId, String status) {
        try {
            var connection = ConnectionManager.getConnection();

            String sql = """
                    UPDATE post_status
                    SET status = ?
                    WHERE id = ?
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setString(1, status);
            statement.setLong(2, postId);

            var updated = statement.executeUpdate();

            return updated > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
