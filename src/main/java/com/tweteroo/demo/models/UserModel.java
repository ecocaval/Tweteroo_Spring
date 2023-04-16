package com.tweteroo.demo.models;

import com.tweteroo.demo.Dtos.UserDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 50, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String avatar;

    public UserModel(UserDto user) {
        this.userName = user.userName();
        this.avatar = user.avatar();
    }
}
