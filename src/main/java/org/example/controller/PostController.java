package org.example.controller;

import org.example.service.PostService;
import org.example.service.impl.PostServiceImpl;
import org.example.utils.ApplicationConfig;
import org.example.utils.Utils;

public class PostController {
    private final PostService postService;

    public PostController() {
        this.postService = new PostServiceImpl();
    }

    public void executeOperation(){
        int operationNumber = Utils.getIntFromInput(ApplicationConfig.SELECT_ENTITY_OPERATION_MESSAGE);

    }
}
