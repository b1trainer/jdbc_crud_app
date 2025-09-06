package org.example.repository.impl;

import org.example.model.PostStatus;
import org.example.repository.PostStatusRepository;
import org.example.utils.ConnectionManager;

import java.sql.SQLException;
import java.sql.Types;
import java.util.UUID;

public class PostStatusRepositoryImpl implements PostStatusRepository {

    @Override
    public PostStatus getById(UUID postId) {
        try (var connection = ConnectionManager.open()) {
            String sql = """
                    SELECT id, status
                    FROM post_status
                    WHERE id = ?
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setObject(1, postId, Types.BINARY);

            var result = statement.executeQuery();

            if(result.next()) {
                PostStatus postStatus = new PostStatus();
                postStatus.setId(result.getObject(1, UUID.class));
                postStatus.setStatus(result.getString(2));
                return postStatus;
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updatePostStatus(UUID postId, String status) {
        try (var connection = ConnectionManager.open()) {
            String sql = """
                    UPDATE post_status
                    SET status = ?
                    WHERE id = ?
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setString(1, status);
            statement.setObject(2, postId, Types.BINARY);

            var updated = statement.executeUpdate();

            return updated > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(UUID postId) {
        try (var connection = ConnectionManager.open()) {
            String sql = """
                    DELETE FROM post_status
                    WHERE id = ?
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setObject(1, postId, Types.BINARY);

            var deleted = statement.executeUpdate();

            return deleted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
