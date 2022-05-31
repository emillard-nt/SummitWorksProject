package com.brightrace.summitworksproject.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.brightrace.summitworksproject.model.User user = userService.getByUsername(username);

        if (user != null) {
            return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
        } else {
            System.out.println("Error Log: JwtUserDetailsService.class (1)");
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

    }

}