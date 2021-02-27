package com.example.challenge.entelgy.service;

import com.example.challenge.entelgy.model.managed.comments.Comment;
import reactor.core.publisher.Flux;

public interface CommentService {

    public Flux<Comment> getComments();

}
