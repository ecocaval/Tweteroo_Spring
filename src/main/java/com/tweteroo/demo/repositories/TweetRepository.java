package com.tweteroo.demo.repositories;

import com.tweteroo.demo.models.TweetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<TweetModel, Integer> {
}
