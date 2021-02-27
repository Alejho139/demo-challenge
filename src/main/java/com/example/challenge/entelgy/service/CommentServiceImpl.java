package com.example.challenge.entelgy.service;

import com.example.challenge.entelgy.model.managed.comments.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private WebClient client;

    @Override
    public Flux<Comment> getComments() {
        return client.get()
                .uri("/comments")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Comment.class);
    }
}
