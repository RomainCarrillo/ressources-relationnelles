package com.cesi.ressourcesrelationnelles.features.comments;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cesi.ressourcesrelationnelles.domain.Comment;

public interface CommentRepository extends MongoRepository<Comment, Long> {
}
