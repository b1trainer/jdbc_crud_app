package org.example.service;

import java.util.List;

public interface LabelService {
    public List<String> getAllLabels();

    public String createLabel(String label);

    public String deleteLabel(String label);

    public String updateLabel(String oldLabel, String newLabel);
}
