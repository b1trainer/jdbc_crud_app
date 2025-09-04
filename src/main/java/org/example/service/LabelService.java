package org.example.service;

import java.util.List;

public interface LabelService {
    public String getLabelById(Long id);

    public String createLabel(String label);

    public String deleteLabel(Long id);

    public String updateLabel(Long id, String newLabel);
}
