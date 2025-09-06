package org.example.controller;

import org.example.model.Writer;
import org.example.service.WriterService;
import org.example.service.impl.WriterServiceImpl;
import org.example.utils.Utils;

import java.util.Optional;
import java.util.Scanner;

import static org.example.utils.ApplicationConfig.*;

public class WriterController {

    private final WriterService writerService;

    public WriterController() {
        this.writerService = new WriterServiceImpl();
    }

    public void executeOperation() {
        int operationId = Utils.getIntFromInput(SELECT_ENTITY_OPERATION_MESSAGE);

        switch (operationId) {
            case CREATE_ENTITY_OPERATION_ID:
                createWriter();
                break;

            case READ_ENTITY_OPERATION_ID:
                readWriter();
                break;

            case UPDATE_ENTITY_OPERATION_ID:
                updateWriter();
                break;

            case DELETE_ENTITY_OPERATION_ID:
                deleteWriter();
                break;

            default:
                System.out.println("Некорректный идентификатор операции!");
                break;
        }
    }

    private void createWriter() {
        Scanner scanner = Utils.getScanner();

        System.out.println("Введите имя нового автора:");
        String firstName = scanner.nextLine();

        System.out.println("Введите фамилию нового автора:");
        String lastName = scanner.nextLine();

        writerService.createWriter(firstName, lastName);
    }

    private void readWriter() {
        Scanner scanner = Utils.getScanner();

        System.out.println("Введите идентификатор автора для прочтения:");
        String authorId = scanner.nextLine();

        Optional<Writer> writer = Optional.ofNullable(writerService.getWriter(authorId));

        if (writer.isPresent()) {
            System.out.println("Искомый автор: " + writer);
        } else {
            System.out.println("Искомый автор не найден");
        }
    }

    private void updateWriter() {
        Scanner scanner = Utils.getScanner();

        System.out.println("Введите идентификатор автора для обновления:");
        String authorId = scanner.nextLine();

        System.out.println("Введите новое имя автора (ничего не вводите, если не хотите его изменять):");
        String newFirstName = scanner.nextLine();

        System.out.println("Введите новую фамилию автора (ничего не вводите, если не хотите его изменять):");
        String newLastName = scanner.nextLine();

        boolean isUpdated = writerService.updateWriter(authorId, newFirstName, newLastName);

        if (isUpdated) {
            System.out.println("Информация об авторе корректно обновлена");
        }
    }

    private void deleteWriter() {
        Scanner scanner = Utils.getScanner();

        System.out.println("Введите идентификатор автора для его удаления:");
        String authorId = scanner.nextLine();

        boolean isDeleted = writerService.deleteWriter(authorId);

        if (isDeleted) {
            System.out.println("Информация об авторе корректно удалена");
        }
    }
}
