package org.example.service.impl;

import org.example.model.Label;
import org.example.repository.LabelRepository;
import org.example.repository.impl.LabelRepositoryImpl;
import org.example.service.LabelService;

import java.util.UUID;

public class LabelServiceImpl implements LabelService {

    private final LabelRepository labelRepository;

    public LabelServiceImpl() {
        this.labelRepository = new LabelRepositoryImpl();
    }

    @Override
    public Label getLabelById(String id) {
        UUID labelId = UUID.fromString(id);

        return labelRepository.getLabelById(labelId);
    }

    @Override
    public void createLabel(String label) {
        UUID newId = UUID.randomUUID();

        Label newLabel = new Label();
        newLabel.setId(newId);
        newLabel.setName(label);

        labelRepository.createLabel(newLabel);
    }

    @Override
    public boolean deleteLabel(String id) {
        UUID labelId = UUID.fromString(id);

        return labelRepository.deleteById(labelId);
    }

    @Override
    public boolean updateLabel(String id, String newLabel) {
        UUID labelId = UUID.fromString(id);

        return labelRepository.updateLabel(labelId, newLabel);
    }
}
