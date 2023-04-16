package com.tweteroo.demo.services;

import com.tweteroo.demo.models.TweetModel;
import com.tweteroo.demo.repositories.TweetRepository;
import org.springframework.stereotype.Service;

@Service
public class TweetService {

    final TweetRepository tweetRepository;

    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public TweetModel postTweet(TweetModel tweet) {
        return tweetRepository.save(tweet);
    }

}
