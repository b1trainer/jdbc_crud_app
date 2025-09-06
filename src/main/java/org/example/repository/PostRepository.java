package org.example.repository;

import org.example.model.Post;

import java.time.Instant;

public interface PostRepository {
    void createPost(Post post);

    void deleteById(Long id);

    Post getPostById(Long id);

    void updatePost(Long id, String content, Instant updateTime, String labels);
}
