package org.example.controller;

import org.example.model.Writer;
import org.example.service.WriterService;
import org.example.service.impl.WriterServiceImpl;

public class WriterController {

    private final WriterService writerService;

    public WriterController() {
        this.writerService = new WriterServiceImpl();
    }

    public Writer getWriterByName(String firstName, String lastName) {
        Writer writer = writerService.getWriter(firstName, lastName);

        return writer;
    }
}
