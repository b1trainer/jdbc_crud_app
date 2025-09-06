package org.example.repository;

import org.example.model.Writer;

import java.util.UUID;

public interface WriterRepository {
    void createWriter(Writer writer);

    Writer getById(UUID id);

    boolean updateWriter(UUID id, String firstName, String lastName);

    boolean deleteById(UUID id);
}
