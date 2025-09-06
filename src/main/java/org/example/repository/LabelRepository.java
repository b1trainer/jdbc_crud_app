package org.example.repository;

import org.example.model.Label;

import java.util.UUID;

public interface LabelRepository {
    Label getLabelById(UUID id);

    void createLabel(Label newLabel);

    boolean deleteById(UUID id);

    boolean updateLabel(UUID id, String newLabel);
}
