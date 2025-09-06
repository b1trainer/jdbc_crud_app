package org.example.repository;

import org.example.model.PostStatus;

import java.util.UUID;

public interface PostStatusRepository {
    PostStatus getById(UUID postId);

    boolean updatePostStatus(UUID postId, String status);

    boolean deleteById(UUID postId);
}
