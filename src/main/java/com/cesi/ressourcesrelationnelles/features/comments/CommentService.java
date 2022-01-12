package com.cesi.ressourcesrelationnelles.features.comments;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> list() {
        return commentRepository.findAll();
    }

    public void createList(List<Comment> comments) {
        commentRepository.saveAll(comments);
    }

}
