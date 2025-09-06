package org.example.controller;

import org.example.model.Label;
import org.example.service.LabelService;
import org.example.service.impl.LabelServiceImpl;
import org.example.utils.Utils;

import static org.example.utils.ApplicationConfig.*;

import java.util.Optional;
import java.util.Scanner;

public class LabelController {

    private final LabelService labelService;

    public LabelController() {
        this.labelService = new LabelServiceImpl();
    }

    public void executeOperation() {
        int operationId = Utils.getIntFromInput(SELECT_ENTITY_OPERATION_MESSAGE);

        switch (operationId) {
            case CREATE_ENTITY_OPERATION_ID:
                createLabel();
                break;

            case READ_ENTITY_OPERATION_ID:
                getLabelById();
                break;

            case UPDATE_ENTITY_OPERATION_ID:
                updateLabel();
                break;

            case DELETE_ENTITY_OPERATION_ID:
                deleteLabel();
                break;

            default:
                System.out.println("Некорректный идентификатор операции!");
                break;
        }
    }

    private void createLabel() {
        Scanner scanner = Utils.getScanner();

        System.out.println("Введите новое название метки:");
        String labelName = scanner.nextLine();

        labelService.createLabel(labelName);
    }

    private void deleteLabel() {
        Scanner scanner = Utils.getScanner();

        System.out.println("Введите идентификатор метки для удаления:");
        String labelId = scanner.nextLine();

        boolean isDeleted = labelService.deleteLabel(labelId);

        if (isDeleted) {
            System.out.println("Метка корректно удалена");
        }
    }

    private void updateLabel() {
        Scanner scanner = Utils.getScanner();

        System.out.println("Введите идентификатор метки для обновления:");
        String labelId = scanner.nextLine();

        System.out.println("Введите новое имя метки:");
        String newLabelName = scanner.nextLine();

        boolean isUpdated = labelService.updateLabel(labelId, newLabelName);

        if (isUpdated) {
            System.out.println("Метка корректно обновлена");
        }
    }

    private void getLabelById() {
        Scanner scanner = Utils.getScanner();

        System.out.println("Введите идентификатор метки которую хотите прочитать:");
        String labelId = scanner.nextLine();

        Optional<Label> label = Optional.ofNullable(labelService.getLabelById(labelId));

        if (label.isPresent()) {
            System.out.println("Искомая метка: " + label);
        } else {
            System.out.println("Искомая метка не найдена");
        }
    }
}
