package com.example.challenge.entelgy.service;

import com.example.challenge.entelgy.model.managed.comments.Comment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private WebClient client;

    @Autowired
    private CommentService commentService;

    @Test
    public void testGetComments() {

        Flux<Comment> comments = commentService.getComments();

        Assert.assertNotNull(comments);
    }
}
