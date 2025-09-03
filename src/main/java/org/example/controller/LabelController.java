package org.example.controller;

import org.example.service.LabelService;
import org.example.service.impl.LabelServiceImpl;
import org.example.utils.ApplicationConfig;
import org.example.utils.Utils;

public class LabelController {

    private final LabelService labelService;

    public LabelController() {
        this.labelService = new LabelServiceImpl();
    }

    public void executeOperation(){
        int operationId = Utils.getIntFromInput(ApplicationConfig.SELECT_ENTITY_OPERATION_MESSAGE);

    }

    public void createLabel() {}

    public void deleteLabel() {}

    public void updateLabel() {}

    public void getLabelById(Long id) {}
}
