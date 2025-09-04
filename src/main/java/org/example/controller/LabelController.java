package org.example.controller;

import org.example.service.LabelService;
import org.example.service.impl.LabelServiceImpl;
import org.example.utils.ApplicationConfig;
import org.example.utils.Utils;

import java.util.Scanner;

public class LabelController {

    private final LabelService labelService;

    public LabelController() {
        this.labelService = new LabelServiceImpl();
    }

    public void executeOperation() {
        int operationId = Utils.getIntFromInput(ApplicationConfig.SELECT_ENTITY_OPERATION_MESSAGE);

        switch (operationId) {
            case ApplicationConfig.CREATE_ENTITY_OPERATION_ID:
                createLabel();
                break;
            case ApplicationConfig.READ_ENTITY_OPERATION_ID:
                getLabelById();
                break;
            case ApplicationConfig.UPDATE_ENTITY_OPERATION_ID:
                updateLabel();
                break;
            case ApplicationConfig.DELETE_ENTITY_OPERATION_ID:
                deleteLabel();
                break;
            default:
                System.out.println("Некорректный идентификатор операции!");
                break;
        }
    }

    private void createLabel() {
        System.out.println("Введите новое название метки:");

        Scanner scanner = new Scanner(System.in);
        String labelName = scanner.nextLine();

        labelService.createLabel(labelName);
    }

    private void deleteLabel() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите идентификатор метки для удаления:");
        long labelId = scanner.nextLong();

        labelService.deleteLabel(labelId);
    }

    private void updateLabel() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите идентификатор метки для обновления:");
        long labelId = scanner.nextLong();

        System.out.println("Введите новое имя метки:");
        String newLabelName = scanner.nextLine();

        labelService.updateLabel(labelId, newLabelName);
    }

    private void getLabelById() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите идентификатор метки которую хотите прочитать:");
        long labelId = scanner.nextLong();

        labelService.getLabelById(labelId);
    }
}
