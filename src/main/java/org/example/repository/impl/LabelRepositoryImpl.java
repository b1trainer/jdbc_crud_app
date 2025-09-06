package org.example.repository.impl;

import org.example.model.Label;
import org.example.repository.LabelRepository;
import org.example.utils.ConnectionManager;

import java.sql.SQLException;
import java.sql.Types;
import java.util.UUID;

public class LabelRepositoryImpl implements LabelRepository {

    @Override
    public Label getLabelById(UUID id) {
        try (var connection = ConnectionManager.open()) {
            String sql = """
                    SELECT id, name
                    FROM label
                    WHERE id = ?
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setObject(1, id, Types.BINARY);

            var result = statement.executeQuery();

            if (result.next()) {
                Label label = new Label();
                label.setId(result.getObject(1, UUID.class));
                label.setName(result.getString(2));
                return label;
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createLabel(Label newLabel) {
        try (var connection = ConnectionManager.open()) {
            String sql = """
                    INSERT INTO label 
                    VALUES (?, ?)
                    """;

            var statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(UUID id) {
        try (var connection = ConnectionManager.open()) {
            String sql = """
                    DELETE FROM label
                    WHERE id = ?
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setObject(1, id, Types.BINARY);

            int deleted = statement.executeUpdate();

            return deleted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateLabel(UUID id, String newLabel) {
        try (var connection = ConnectionManager.open()) {
            String sql = """
                    UPDATE label
                    SET name = ?
                    WHERE id = ?
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setString(1, newLabel);
            statement.setObject(2, id, Types.BINARY);

            var updated = statement.executeUpdate();

            return updated > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
