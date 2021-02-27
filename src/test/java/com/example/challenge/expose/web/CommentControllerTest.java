package com.example.challenge.expose.web;

import com.example.challenge.entelgy.model.api.ChallengeResponse;
import com.example.challenge.entelgy.model.managed.comments.Comment;
import com.example.challenge.entelgy.service.CommentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentControllerTest {

    @MockBean
    private CommentService commentService;

    @Autowired
    private CommentController commentController;

    @Before
    public void setUp() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setId(2);
        comment.setEmail("alejo@comment.com");

        Mockito.when(commentService.getComments()).thenReturn(Flux.just(comment));
    }

    @Test
    public void testComments() {
        Mono<ChallengeResponse> response = commentController.comments();
        ChallengeResponse challengeResponse = response.block();

        Assert.assertNotNull(response);
        Assert.assertEquals(challengeResponse.getData().get(0), "1|2|alejo@comment.com");
    }
}
