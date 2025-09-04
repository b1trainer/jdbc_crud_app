package org.example.controller;

import org.example.PostStatus;
import org.example.model.Post;
import org.example.service.PostService;
import org.example.service.impl.PostServiceImpl;
import org.example.utils.ApplicationConfig;
import org.example.utils.Utils;

import java.time.Instant;
import java.util.Scanner;
import java.util.UUID;

public class PostController {
    private final PostService postService;

    public PostController() {
        this.postService = new PostServiceImpl();
    }

    public void executeOperation() {
        int operationId = Utils.getIntFromInput(ApplicationConfig.SELECT_ENTITY_OPERATION_MESSAGE);

        switch (operationId) {
            case ApplicationConfig.CREATE_ENTITY_OPERATION_ID:
                createPost();
                break;
            case ApplicationConfig.READ_ENTITY_OPERATION_ID:
                getPostById();
                break;
            case ApplicationConfig.UPDATE_ENTITY_OPERATION_ID:
                updatePost();
                break;
            case ApplicationConfig.DELETE_ENTITY_OPERATION_ID:
                deletePost();
                break;
            default:
                break;
        }

    }

    private void createPost() {
        Scanner scanner = new Scanner(System.in);

        Post post = new Post();

        UUID postId = UUID.randomUUID();
        post.setId(postId);

        System.out.println("Введите содержимое для поста");
        String content = scanner.nextLine();
        post.setContent(content);

        Instant now = Instant.now();
        post.setCreated(now);
        post.setUpdated(now);

//        System.out.println("Введите метки для поста");

        post.setStatus(PostStatus.UNDER_REVIEW);
        postService.createPost(post);
    }

    private void getPostById() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите id поста для получения:");
        long postId = scanner.nextLong();

        postService.getPost(postId);
    }

    private void updatePost() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите id поста для обновления");
        long postId = scanner.nextLong();
        Instant updateTime = Instant.now();
    }

    private void deletePost() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите id поста для удаления");
        long postId = scanner.nextLong();

        postService.deletePost(postId);
    }

}
