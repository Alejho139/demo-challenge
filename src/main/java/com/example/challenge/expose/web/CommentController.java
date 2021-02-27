package com.example.challenge.expose.web;

import com.example.challenge.entelgy.model.api.ChallengeResponse;
import com.example.challenge.entelgy.service.CommentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/challenge")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/comments")
    public Mono<ChallengeResponse> comments() {
        ChallengeResponse response = new ChallengeResponse();
        List<String> data = new ArrayList<>();
        return commentService.getComments().collectList()
                .map(comments -> {
                    comments.forEach(comment -> data.add(comment.getPostId() + "|" + comment.getId() + "|" + comment.getEmail()));
                    return data;
                })
                .map(dr -> {
                    response.setData(dr);
                    return response;
                });
    }
}
