package com.cesi.ressourcesrelationnelles.comments;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentsController {

    @GetMapping("/all-comments")
    public String getAllComments() {
        return "Here are all the comments";
    }
}
