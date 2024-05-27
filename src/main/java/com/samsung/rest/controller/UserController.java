package com.samsung.rest.controller;


import com.samsung.mapper.UserMapper;
import com.samsung.rest.dto.UserProfileDto;
import com.samsung.rest.dto.UserRegisterDto;
import com.samsung.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{email}")
    public String findUserByEmail(@PathVariable("email") String email) {
        UserProfileDto userDto = UserMapper.toUserProfileDto(userService.findByEmail(email));
        return "User " + userDto.getEmail() + " is registered";
    }

    @PostMapping("/user/register")
    public UserProfileDto add(@RequestBody UserRegisterDto userDto) {
        return UserMapper.toUserProfileDto(userService.save(UserMapper.fromDto(userDto)));
    }

    @GetMapping("/user/login")
    public UserRegisterDto login(Authentication authentication) {
        return UserMapper.toUserRegisterDto(userService.findByEmail(authentication.getName()));
    }

    @GetMapping("/user/{id}")
    public UserProfileDto getUserById(@PathVariable long id) {
        return UserMapper.toUserProfileDto(userService.getById(id));
    }

    @PutMapping("/user/{id}")
    public UserProfileDto update(@PathVariable Long id, @RequestBody UserProfileDto userProfileDto) {
        return UserMapper.toUserProfileDto(userService.update(id, UserMapper.fromDto(userProfileDto)));
    }
}
