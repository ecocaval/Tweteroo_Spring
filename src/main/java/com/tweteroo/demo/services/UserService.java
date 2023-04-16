package com.tweteroo.demo.services;

import com.tweteroo.demo.models.UserModel;
import com.tweteroo.demo.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Transactional
    public UserModel signUpUser(UserModel user) {
        return userRepository.save(user);
    }
}
