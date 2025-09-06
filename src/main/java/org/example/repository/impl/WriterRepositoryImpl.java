package org.example.repository.impl;

import org.example.model.Writer;
import org.example.repository.WriterRepository;
import org.example.utils.ConnectionManager;

import java.sql.SQLException;
import java.sql.Types;
import java.util.UUID;

public class WriterRepositoryImpl implements WriterRepository {

    @Override
    public void createWriter(Writer writer) {
        try (var connection = ConnectionManager.open()) {
            String sql = """
                    INSERT INTO writer 
                    VALUES (?,?,?)
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setObject(1, writer.getId(), Types.BINARY);
            statement.setString(2, writer.getFirstName());
            statement.setString(3, writer.getLastName());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Writer getById(UUID id) {
        try (var connection = ConnectionManager.open()) {
            String sql = """
                    SELECT id, firstName, lastName 
                    FROM writer 
                    WHERE id = ?
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setObject(1, id, Types.BINARY);

            var result = statement.executeQuery();

            if (result.next()) {
                Writer writer = new Writer();
                writer.setId(result.getObject(1, UUID.class));
                writer.setFirstName(result.getString(2));
                writer.setLastName(result.getString(3));
                return writer;
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateWriter(UUID id, String firstName, String lastName) {
        try (var connection = ConnectionManager.open()) {
            String sql = """
                    UPDATE writer
                    SET firstName = ?, lastName = ?
                    WHERE id = ?
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setObject(3, id, Types.BINARY);

            var updated = statement.executeUpdate();

            return updated > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(UUID id) {
        try (var connection = ConnectionManager.open()) {
            String sql = """
                    DELETE FROM writer
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
}
