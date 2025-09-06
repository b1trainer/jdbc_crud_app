package org.example;

import org.example.controller.LabelController;
import org.example.controller.PostController;
import org.example.controller.PostStatusController;
import org.example.controller.WriterController;
import org.example.utils.ApplicationConfig;
import org.example.utils.Utils;

public class Main {
    public static void main(String[] args) {

        LabelController labelController = new LabelController();
        WriterController writerController = new WriterController();
        PostController postController = new PostController();
        PostStatusController postStatusController = new PostStatusController();

        while (true) {
            int entityNumber = Utils.getIntFromInput(ApplicationConfig.SELECT_ENTITY_MESSAGE);

            switch (entityNumber) {
                case ApplicationConfig.LABEL_ENTITY_ID:
                    labelController.executeOperation();
                    break;

                case ApplicationConfig.WRITER_ENTITY_ID:
                    writerController.executeOperation();
                    break;

                case ApplicationConfig.POST_ENTITY_ID:
                    postController.executeOperation();
                    break;

                case ApplicationConfig.POST_STATUS_ID:
                    postStatusController.executeOperation();
                    break;

                case ApplicationConfig.EXIT_APPLICATION_OPERATION_ID:
                    System.out.println("Program shutdown...");
                    System.exit(0);

                default:
                    System.out.println("Попробуйте еще раз");
                    break;
            }
        }
    }
}