package com.samsung.rest.controller;

import com.samsung.rest.dto.UserDto;
import com.samsung.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{email}")
    public String findUserByEmail(@PathVariable("email") String email) {
        UserDto userDto = UserDto.toDto(userService.findByEmail(email));
        return "User " + userDto.getEmail() + " is registered";
    }

    @PostMapping("/user")
    public UserDto insertUser(@RequestBody UserDto userDto) {
        return UserDto.toDto(userService.save(UserDto.fromDto(userDto)));
    }

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable long id) {
        return UserDto.toDto(userService.getById(id));
    }
}
