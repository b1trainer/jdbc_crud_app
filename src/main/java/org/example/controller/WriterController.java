package org.example.controller;

import org.example.model.Writer;
import org.example.service.WriterService;
import org.example.service.impl.WriterServiceImpl;
import org.example.utils.ApplicationConfig;
import org.example.utils.Utils;

public class WriterController {

    private final WriterService writerService;

    public WriterController() {
        this.writerService = new WriterServiceImpl();
    }

    public void executeOperation() {
        int operationId = Utils.getIntFromInput(ApplicationConfig.SELECT_ENTITY_OPERATION_MESSAGE);

    }

    public Writer getWriterByName(String firstName, String lastName) {
        Writer writer = writerService.getWriter(firstName, lastName);

        return writer;
    }
}
