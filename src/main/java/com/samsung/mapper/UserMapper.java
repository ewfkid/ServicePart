package com.samsung.mapper;

import com.samsung.domain.User;
import com.samsung.rest.dto.UserProfileDto;
import com.samsung.rest.dto.UserRegisterDto;

public class UserMapper {

    public static User fromDto(UserProfileDto userProfileDto) {

        return User.builder()
                .id(userProfileDto.getId())
                .name(userProfileDto.getName())
                .email(userProfileDto.getEmail())
                .photoUrl(userProfileDto.getPhotoUrl())
                .build();
    }

    public static User fromDto(UserRegisterDto userRegisterDto) {

        User user = User.builder()
                .password(userRegisterDto.getPassword())
                .email(userRegisterDto.getEmail())
                .build();

        if (userRegisterDto.getId() != null) user.setId(userRegisterDto.getId());

        return user;
    }

    public static UserRegisterDto toUserRegisterDto(User user) {

        return UserRegisterDto.builder()
                .id(user.getId())
                .password(user.getPassword())
                .email(user.getPassword())
                .build();
    }

    public static UserProfileDto toUserProfileDto(User user) {

        return UserProfileDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .photoUrl(user.getPhotoUrl())
                .build();
    }
}
