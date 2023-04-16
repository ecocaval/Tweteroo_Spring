package com.tweteroo.demo.controllers;

import com.tweteroo.demo.Dtos.TweetDto;
import com.tweteroo.demo.models.TweetModel;
import com.tweteroo.demo.models.UserModel;
import com.tweteroo.demo.services.TweetService;
import com.tweteroo.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping
    public Page<TweetModel> findAll(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        return tweetService.findAll(pageable);
    }

    @GetMapping("/{userName}")
    public Page<TweetModel> findByUserName(@PageableDefault(page = 0, size = 5) Pageable pageable, @PathVariable String userName) {
        return tweetService.findByUserName(pageable, userName);
    }

    @PostMapping
    public ResponseEntity<?> postTweet(@RequestBody @Valid TweetDto tweet) {
        return ResponseEntity.status(HttpStatus.OK).body(tweetService.postTweet(new TweetModel(tweet)));
    }
}
