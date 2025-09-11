package org.example.repository.impl;

import org.example.mappers.RowMapper;
import org.example.mappers.impl.WriterMapper;
import org.example.model.Writer;
import org.example.repository.WriterRepository;
import org.example.utils.ConnectionManager;

import java.sql.SQLException;

public class WriterRepositoryImpl implements WriterRepository {

    @Override
    public boolean createWriter(Writer writer) {
        try {
            var connection = ConnectionManager.getConnection();

            String sql = """
                    INSERT INTO writers (firstName, lastName)
                    SELECT * FROM (SELECT ? as firstName, ? as lastName) as value
                    WHERE NOT EXISTS (
                        SELECT firstName, lastName FROM writers WHERE firstName = ? AND lastName = ?
                    ) LIMIT 1
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setString(1, writer.getFirstName());
            statement.setString(2, writer.getLastName());

            statement.setString(3, writer.getFirstName());
            statement.setString(4, writer.getLastName());

            var result = statement.executeUpdate();

            return result > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Writer getById(Long id) {
        try {
            var connection = ConnectionManager.getConnection();

            String sql = """
                    SELECT id, firstName, lastName
                    FROM writers
                    WHERE id = ?
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            var result = statement.executeQuery();

            RowMapper<Writer> mapper = new WriterMapper();
            if (result.next()) {
                return mapper.mapRow(result);
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateWriter(Long id, String firstName, String lastName) {
        try {
            var connection = ConnectionManager.getConnection();

            String sql = """
                    UPDATE writers
                    SET firstName = ?, lastName = ?
                    WHERE id = ?
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setLong(3, id);

            var updated = statement.executeUpdate();

            return updated > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            var connection = ConnectionManager.getConnection();

            String sql = """
                    DELETE FROM writers
                    WHERE id = ?
                    """;

            var statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            int deleted = statement.executeUpdate();

            return deleted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
