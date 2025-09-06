package org.example.model;

import java.util.UUID;

public class Label {
    private UUID id;
    private String name;

    public Label() {
    }

    public Label(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Label{" +
                "name='" + name + '\'' +
                '}';
    }
}
