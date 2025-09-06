package org.example.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Post {
    private UUID id;
    private String content;
    private Instant created;
    private Instant updated;
    private List<Label> labels;
    private PostStatus status;

    public Post() {
    }

    public Post(UUID id, String content, Instant created, Instant updated, List<Label> labels, PostStatus status) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.labels = labels;
        this.status = status;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Instant getCreated() {
        return created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public PostStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Post{" +
                "content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", labels=" + labels +
                ", status=" + status +
                '}';
    }
}
