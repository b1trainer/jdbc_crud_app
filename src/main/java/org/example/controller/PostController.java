package org.example.controller;

import org.example.service.PostService;
import org.example.service.impl.PostServiceImpl;
import org.example.utils.Utils;

import static org.example.utils.ApplicationConfig.*;

import java.util.Scanner;

public class PostController {
    private final PostService postService;

    public PostController() {
        this.postService = new PostServiceImpl();
    }

    public void executeOperation() {
        int operationId = Utils.getIntFromInput(SELECT_ENTITY_OPERATION_MESSAGE);

        switch (operationId) {
            case CREATE_ENTITY_OPERATION_ID:
                createPost();
                break;

            case READ_ENTITY_OPERATION_ID:
                getPostById();
                break;

            case UPDATE_ENTITY_OPERATION_ID:
                updatePost();
                break;

            case DELETE_ENTITY_OPERATION_ID:
                deletePost();
                break;

            default:
                System.out.println("Некорректный идентификатор операции!");
                break;
        }
    }

    private void createPost() {
        Scanner scanner = Utils.getScanner();

        System.out.println("Введите содержимое для поста");
        String content = scanner.nextLine();

        System.out.println("Введите через запятую метки для поста");
        String labels = scanner.nextLine();

        postService.createPost(content, labels);
    }

    private void getPostById() {
        Scanner scanner = Utils.getScanner();

        System.out.println("Введите id поста для получения:");
        long postId = scanner.nextLong();

        postService.getPost(postId);
    }

    private void updatePost() {
        Scanner scanner = Utils.getScanner();

        System.out.println("Введите id поста для обновления");
        long postId = scanner.nextLong();

        System.out.println("Введите новый контент для поста (ничего не вводите, если не хотите его изменять)");
        String newContent = scanner.nextLine();

        System.out.println("Введите через запятую новые метки для поста (ничего не вводите, если не хотите их изменять)");
        String labels = scanner.nextLine();

        postService.updatePost(postId, newContent, labels);

    }

    private void deletePost() {
        Scanner scanner = Utils.getScanner();

        System.out.println("Введите id поста для удаления");
        long postId = scanner.nextLong();

        postService.deletePost(postId);
    }

}
