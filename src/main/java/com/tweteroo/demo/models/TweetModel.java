package com.tweteroo.demo.models;

import com.tweteroo.demo.Dtos.TweetDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tweets")
@NoArgsConstructor
public class TweetModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 50, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String avatar;

    @Column(length = 300, nullable = false)
    private String text;

    public TweetModel(TweetDto tweet) {
        this.userName = tweet.userName();
        this.avatar = tweet.avatar();
        this.text = tweet.text();
    }
}

