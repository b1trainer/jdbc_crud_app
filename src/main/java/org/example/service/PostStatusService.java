package org.example.service;

import org.example.model.PostStatus;

public interface PostStatusService {
    PostStatus getPostStatus(String postId);

    boolean updatePostStatus(String postId, String status);

    boolean deletePostStatus(String postId);
}
