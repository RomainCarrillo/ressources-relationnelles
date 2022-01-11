package com.cesi.ressourcesrelationnelles.features.comments;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentsController {

    @GetMapping("/comments")
    public String getAllComments() {
        return "Here are all the comments";
    }
}
