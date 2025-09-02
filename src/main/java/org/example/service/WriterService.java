package org.example.service;

import org.example.model.Writer;

public interface WriterService {
    public String createWriter(Writer writer);

    public Writer getWriter(String firstName, String lastName);

    public String updateWriter(Writer writer);

    public String deleteWriter(String writerId);
}
