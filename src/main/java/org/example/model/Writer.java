package org.example.model;

import java.util.List;
import java.util.UUID;

public class Writer {
    private UUID id;
    private String firstName;
    private String lastName;
    private List<Post> posts;

    public Writer() {
    }

    public Writer(UUID id, String firstName, String lastName, List<Post> posts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = posts;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "Writer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", posts=" + posts +
                '}';
    }
}
