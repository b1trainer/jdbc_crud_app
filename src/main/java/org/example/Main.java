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
            case 0:
                System.exit(0);
            case 1:
                labelController.executeOperation();
                break;
            case 2:
                writerController.executeOperation();
                break;
            case 3:
                postController.executeOperation();
                break;
            default:
                break;
        }
    }

}