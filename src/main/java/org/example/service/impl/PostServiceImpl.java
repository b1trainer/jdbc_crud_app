package org.example.service.impl;

import org.example.model.Label;
import org.example.model.Post;
import org.example.repository.PostRepository;
import org.example.repository.impl.PostRepositoryImpl;
import org.example.service.PostService;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl() {
        this.postRepository = new PostRepositoryImpl();
    }

    @Override
    public String createPost(String content, String labels) {
        Post post = new Post();
        UUID id = UUID.randomUUID();

        List<Label> labelsList = Arrays.stream(labels.split(",")).map(labelName -> {
            Label label = new Label();
            label.setId(UUID.randomUUID());
            label.setName(labelName);
            return label;
        }).toList();

        post.setId(id);
        post.setContent(content);
        post.setCreated(Instant.now());
        post.setUpdated(Instant.now());
        post.setLabels(labelsList);

        postRepository.createPost(post);

        return id.toString();
    }

    @Override
    public Post getPost(Long id) {
        return postRepository.getPostById(id);
    }

    @Override
    public String updatePost(Long id, String content, String labels) {
        Instant updateTime = Instant.now();
        postRepository.updatePost(id, content, updateTime, labels);

        return id.toString();
    }

    @Override
    public String deletePost(Long id) {
        postRepository.deleteById(id);

        return id.toString();
    }
}
