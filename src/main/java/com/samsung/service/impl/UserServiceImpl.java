package com.samsung.service.impl;

import com.samsung.domain.User;
import com.samsung.exeption.UserAlreadyExistsException;
import com.samsung.exeption.UserNotFoundException;
import com.samsung.dao.UserRepository;
import com.samsung.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (userRepository.findByEmail(user.getEmail()).isPresent())
            throw new UserAlreadyExistsException("user with email " + user.getEmail() + "already exists");
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(
                "user  with email " + email + " was not found"));
    }

    @Override
    public User update(Long id, User user) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(
                "user  with email " + id + " was not found"));

        if (user.getName() != null) user.setName(user.getName());
        if (user.getEmail() != null) user.setEmail(user.getEmail());
        if (user.getPhotoUrl() != null) user.setPhotoUrl(user.getPhotoUrl());
        return userRepository.save(user);
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(
                "user  with id " + id + " was not found"));
    }


}
