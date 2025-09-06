package org.example.controller;

import org.example.model.PostStatus;
import org.example.service.PostStatusService;
import org.example.service.impl.PostStatusServiceImpl;
import org.example.utils.Utils;

import java.util.Optional;
import java.util.Scanner;

import static org.example.utils.ApplicationConfig.*;

public class PostStatusController {

    private final PostStatusService postStatusService;

    public PostStatusController() {
        this.postStatusService = new PostStatusServiceImpl();
    }

    public void executeOperation() {
        int operationId = Utils.getIntFromInput(SELECT_ENTITY_OPERATION_MESSAGE);

        switch (operationId) {
            case READ_ENTITY_OPERATION_ID:
                getStatusById();
                break;

            case UPDATE_ENTITY_OPERATION_ID:
                updateStatus();
                break;

            case DELETE_ENTITY_OPERATION_ID:
                deleteStatus();
                break;

            default:
                System.out.println("Некорректный идентификатор операции!");
                break;
        }
    }

    private void getStatusById() {
        Scanner scanner = Utils.getScanner();

        System.out.println("Введите id поста для получения статуса");
        String postId = scanner.nextLine();

        Optional<PostStatus> status = Optional.ofNullable(postStatusService.getPostStatus(postId));

        if (status.isPresent()) {
            System.out.println("Cтатус поста: " + status);
        } else {
            System.out.println("Cтатус поста не найден");
        }
    }

    private void updateStatus() {
        Scanner scanner = Utils.getScanner();

        System.out.println("Введите id поста для обновления статуса");
        String postId = scanner.nextLine();

        String selectStatusMessage = """
                Выберите новый статус поста
                1. ACTIVE
                2. UNDER_REVIEW
                """;

        String status = null;
        int newStatus = Utils.getIntFromInput(selectStatusMessage);
        switch (newStatus) {
            case 1:
                status = "ACTIVE";
                break;
            case 2:
                status = "UNDER_REVIEW";
                break;
            default:
                System.out.println("Некорректно выбранный статус");
        }

        if (status != null) {
            boolean isUpdated = postStatusService.updatePostStatus(postId, status);

            if (isUpdated) {
                System.out.println("Статус поста корректно обновлен");
            }
        }
    }

    private void deleteStatus() {
        Scanner scanner = Utils.getScanner();

        System.out.println("Введите id поста для удаления его статуса");
        String postId = scanner.nextLine();

        boolean isDeleted = postStatusService.deletePostStatus(postId);

        if (isDeleted) {
            System.out.println("Статус поста удален");
        }
    }
}
