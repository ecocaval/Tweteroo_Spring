package com.tweteroo.demo.controllers;

import com.tweteroo.demo.Dtos.TweetDto;
import com.tweteroo.demo.models.TweetModel;
import com.tweteroo.demo.models.UserModel;
import com.tweteroo.demo.services.TweetService;
import com.tweteroo.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping
    public ResponseEntity<?> postTweet(@RequestBody @Valid TweetDto tweet) {
        return ResponseEntity.status(HttpStatus.OK).body(tweetService.postTweet(new TweetModel(tweet)));
    }
}
