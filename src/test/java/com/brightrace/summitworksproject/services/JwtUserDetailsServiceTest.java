package com.brightrace.summitworksproject.services;

import com.brightrace.summitworksproject.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class JwtUserDetailsServiceTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private JwtUserDetailsService jwtService;

    @Test
    void loadUserByUsernameTest() {

        String username = "albert@brightrace.com";
        final User userTest = new User(1, "Albert", "Allen", username, "a-password", "regular");

        List<User> userList = new ArrayList();
        userList.add(userTest);
        userList.add(new User(2, "Billy", "Baker", "billy@brightrace.com", "b-password", "regular"));
        userList.add(new User(3, "Catherine", "Collins", "catherine@brightrace.com", "c-password", "regular"));

        given(userService.getByEmail(username)).willReturn(userTest);

        UserDetails userDetailsExpected = jwtService.loadUserByUsername(username);

        assertEquals(userDetailsExpected, new org.springframework.security.core.userdetails.User(userTest.getEmail(), userTest.getPassword(), new ArrayList<>()));

    }

}
