package com.samsung.rest.controller;

import com.samsung.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;
}
