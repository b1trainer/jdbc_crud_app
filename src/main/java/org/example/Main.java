package org.example;

import org.example.controller.LabelController;
import org.example.controller.PostController;
import org.example.controller.WriterController;
import org.example.utils.ApplicationConfig;
import org.example.utils.Utils;

public class Main {
    public static void main(String[] args) {

        LabelController labelController = new LabelController();
        PostController postController = new PostController();
        WriterController writerController = new WriterController();

        int entityNumber = Utils.getIntFromInput(ApplicationConfig.SELECT_ENTITY_MESSAGE);

        switch (entityNumber) {
            case ApplicationConfig.EXIT_APPLICATION_OPERATION_ID:
                System.exit(0);
            case ApplicationConfig.LABEL_ENTITY_ID:
                labelController.executeOperation();
                break;
            case ApplicationConfig.WRITER_ENTITY_ID:
                writerController.executeOperation();
                break;
            case ApplicationConfig.POST_ENTITY_ID:
                postController.executeOperation();
                break;
            default:
                System.out.println("Некорректный идентификатор сущности! Попробуйте еще раз.");
                break;
        }
    }

}