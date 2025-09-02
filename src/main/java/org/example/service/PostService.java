package org.example.service;

import org.example.model.Post;

public interface PostService {
    public String createPost(Post post);

    public Post getPost(long id);

    public String updatePost(Post post);

    public String deletePost(long id);
}
