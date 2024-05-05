package com.samsung.security;

import com.samsung.dao.UserRepository;
import com.samsung.domain.User;
import com.samsung.exeption.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);

        User user = userRepository.findByEmail(username).orElseThrow(() -> new UserNotFoundException(
                "user with email " + username + " was not found"
        ));
        return new SecurityUser(user);
    }
}
