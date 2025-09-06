package org.example.service.impl;

import org.example.model.Writer;
import org.example.repository.WriterRepository;
import org.example.repository.impl.WriterRepositoryImpl;
import org.example.service.WriterService;

import java.util.UUID;

public class WriterServiceImpl implements WriterService {

    private final WriterRepository writerRepository;

    public WriterServiceImpl() {
        this.writerRepository = new WriterRepositoryImpl();
    }

    @Override
    public void createWriter(String firstName, String lastName) {
        Writer writer = new Writer();

        UUID id = UUID.randomUUID();
        writer.setId(id);
        writer.setFirstName(firstName);
        writer.setLastName(lastName);

        writerRepository.createWriter(writer);
    }

    @Override
    public Writer getWriter(String id) {
        UUID authorId = UUID.fromString(id);

        return writerRepository.getById(authorId);
    }

    @Override
    public boolean updateWriter(String id, String firstName, String lastName) {
        UUID authorId = UUID.fromString(id);

        return writerRepository.updateWriter(authorId, firstName, lastName);
    }

    @Override
    public boolean deleteWriter(String id) {
        UUID authorId = UUID.fromString(id);

        return writerRepository.deleteById(authorId);
    }
}
