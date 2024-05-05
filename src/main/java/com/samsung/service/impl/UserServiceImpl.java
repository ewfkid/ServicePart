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



}
