package org.example.model;

import java.util.UUID;

public class PostStatus {
//    ACTIVE, UNDER_REVIEW, DELETED

    private UUID id;
    private String status;

    public PostStatus() {
    }

    public PostStatus(UUID id, String status) {
        this.id = id;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PostStatus{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
