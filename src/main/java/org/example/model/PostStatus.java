package org.example.model;

public class PostStatus {
    private Long id;
    private String status;

    public PostStatus() {
    }

    public PostStatus(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return String.format("""
                ===========
                Post id: %d
                Status: %s
                ===========
                """, id, status);
    }
}
