package org.example.repository.impl;

import org.example.model.Post;
import org.example.repository.PostRepository;

import java.time.Instant;

public class PostRepositoryImpl implements PostRepository {
    @Override
    public void createPost(Post post) {
        try {

        } catch (Exception e) {
            System.out.println("Ошибка создания поста: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        try {

        } catch (Exception e) {
            System.out.println("Ошибка удаления поста: " + e.getMessage());
        }
    }

    @Override
    public Post getPostById(Long id) {
        return null;
    }

    @Override
    public void updatePost(Long id, String content, Instant updateTime, String labels) {

    }
}
