package com.tweteroo.demo.controllers;

import com.tweteroo.demo.Dtos.UserDto;
import com.tweteroo.demo.models.UserModel;
import com.tweteroo.demo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> SignUpUser(@RequestBody @Valid UserDto user) {
        boolean userNameIsDuplicated = userService.existsByUserName(user.userName());
        if(userNameIsDuplicated) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This username is already in use!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.signUpUser(new UserModel(user)));
    }

}
