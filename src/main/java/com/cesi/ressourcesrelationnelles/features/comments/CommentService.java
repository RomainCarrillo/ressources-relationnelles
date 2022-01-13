package com.cesi.ressourcesrelationnelles.features.comments;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getList() {
        return commentRepository.findAll();
    }

    public Comment getById(long id) throws NotFoundException {
        return commentRepository.findById(id).orElseThrow(() ->
                new NotFoundException("User not found : "));
    }

    public void createList(List<Comment> comments) {
        commentRepository.saveAll(comments);
    }

    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    public void delete(long id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()) {
            commentRepository.delete(commentRepository.getById(id));
        }
    }

    public void update(Comment comment, long id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()) {
            Comment modifiedComment = commentRepository.getById(id);
            modifiedComment.setAuthor(comment.getAuthor());
            modifiedComment.setTitle(comment.getTitle());
            modifiedComment.setContent(comment.getContent());
            commentRepository.save(modifiedComment);
        }
    }

}
