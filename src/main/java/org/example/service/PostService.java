package org.example.service;

import org.example.model.Post;

import java.util.List;

public interface PostService {
    String createPost(String content, String labels);

    Post getPost(Long id);

    String updatePost(Long id , String content, String labels);

    String deletePost(Long id);
}
