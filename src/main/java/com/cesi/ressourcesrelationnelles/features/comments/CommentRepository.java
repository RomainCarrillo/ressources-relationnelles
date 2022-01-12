package com.cesi.ressourcesrelationnelles.features.comments;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
