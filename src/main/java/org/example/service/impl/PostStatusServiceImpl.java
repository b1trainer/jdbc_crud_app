package org.example.service.impl;

import org.example.model.PostStatus;
import org.example.repository.PostStatusRepository;
import org.example.repository.impl.PostStatusRepositoryImpl;
import org.example.service.PostStatusService;

import java.util.UUID;

public class PostStatusServiceImpl implements PostStatusService {

    private final PostStatusRepository postStatusRepository;

    public PostStatusServiceImpl() {
        this.postStatusRepository = new PostStatusRepositoryImpl();
    }

    @Override
    public PostStatus getPostStatus(String postId) {
        UUID id = UUID.fromString(postId);

        return postStatusRepository.getById(id);
    }

    @Override
    public boolean updatePostStatus(String postId, String status) {
        UUID id = UUID.fromString(postId);

        return postStatusRepository.updatePostStatus(id, status);
    }

    @Override
    public boolean deletePostStatus(String postId) {
        UUID id = UUID.fromString(postId);

        return postStatusRepository.deleteById(id);
    }
}
