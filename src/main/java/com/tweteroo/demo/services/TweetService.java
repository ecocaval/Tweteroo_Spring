package com.tweteroo.demo.services;

import com.tweteroo.demo.models.TweetModel;
import com.tweteroo.demo.repositories.TweetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TweetService {

    final TweetRepository tweetRepository;

    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public Page<TweetModel> findAll(Pageable pageable) {
        return tweetRepository.findAll(pageable);
    }

    public Page<TweetModel> findByUserName(Pageable pageable, String userName) {
        return tweetRepository.findByUserName(pageable, userName);
    }


    public TweetModel postTweet(TweetModel tweet) {
        return tweetRepository.save(tweet);
    }

}
