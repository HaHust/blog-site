package com.h2s.blogsite.security;

import com.h2s.blogsite.entity.User;
import com.h2s.blogsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                                    .orElseThrow(() -> new UsernameNotFoundException("User name not exist"));
        return new SecurityUserDetails(user.getEmail(),user.getPassword());
    }
}
