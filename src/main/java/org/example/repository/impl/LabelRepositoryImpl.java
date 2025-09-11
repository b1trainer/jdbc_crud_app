package org.example.repository.impl;

import org.example.model.Label;
import org.example.repository.LabelRepository;
import org.example.utils.ConnectionManager;

import java.sql.SQLException;

public class LabelRepositoryImpl implements LabelRepository {

    @Override
    public Label getLabelById(Long id) {
        try {
            var connection = ConnectionManager.getConnection();

            String sql = """
                    SELECT id, name
                    FROM labels
                    WHERE id = ?
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            var result = statement.executeQuery();

            if (result.next()) {
                Label label = new Label();
                label.setId(result.getLong(1));
                label.setName(result.getString(2));
                return label;
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean createLabel(Label newLabel) {
        try {
            var connection = ConnectionManager.getConnection();

            String sql = """
                    INSERT INTO labels (name)
                    SELECT * FROM (SELECT ? as label) as value
                    WHERE NOT EXISTS (
                        SELECT name FROM labels WHERE name = ?
                    ) LIMIT 1
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setString(1, newLabel.getName());
            statement.setString(2, newLabel.getName());

            var result = statement.executeUpdate();

            return result > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteLabel(String label) {
        try {
            var connection = ConnectionManager.getConnection();

            String sql = """
                    DELETE FROM labels
                    WHERE name = ?
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setString(1, label);

            int deleted = statement.executeUpdate();

            return deleted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateLabel(Long postId, String label) {
        try {
            var connection = ConnectionManager.getConnection();

            String sql = """ 
                    INSERT IGNORE INTO posts_labels (post_id, label_id)
                    VALUES (?,(
                        SELECT id FROM labels WHERE name = ?)
                    )
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setLong(1, postId);
            statement.setString(2, label);

            var updated = statement.executeUpdate();

            return updated > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
