package com.brightrace.summitworksproject.services;

import com.brightrace.summitworksproject.model.User;
import com.brightrace.summitworksproject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void listAllTest() {

        List<User> userTest = new ArrayList();
        userTest.add(new User(1, "Albert", "Allen", "albert@brightrace.com", "a-password", "regular"));
        userTest.add(new User(2, "Billy", "Baker", "billy@brightrace.com", "b-password", "regular"));
        userTest.add(new User(3, "Catherine", "Collins", "catherine@brightrace.com", "c-password", "regular"));

        given(userRepository.findAll()).willReturn(userTest);

        List<User> userExpected = userService.listAll();

        assertEquals(userExpected, userTest);

    }

    @Test
    void getTest() {

        final Integer id = 1;
        final User userTest = new User(id, "Albert", "Allen", "albert@brightrace.com", "a-password", "regular");

        given(userRepository.findById(id)).willReturn(Optional.of(userTest));

        User userExpected = userService.get(id);

        assertEquals(userExpected, userTest);

    }

    @Test
    void deleteTest() {

        Integer id = 1;

        userService.delete(id);
        userService.delete(id);

        verify(userRepository, times(2)).deleteById(id);

    }

    @Test
    void saveTest() {

        Integer id = 1;
        User userTest = new User(id, "Albert", "Allen", "albert@brightrace.com", "a-password", "regular");

        userService.save(userTest);
        userService.save(userTest);

        verify(userRepository, times(2)).save(userTest);

    }

    @Test
    void getByEmailTest() {

        final String email = "albert@brightrace.com";
        User userTest = new User(1, "Albert", "Allen", email, "a-password", "regular");

        List<User> userList = new ArrayList();
        userList.add(userTest);
        userList.add(new User(2, "Billy", "Baker", "billy@brightrace.com", "b-password", "regular"));
        userList.add(new User(3, "Catherine", "Collins", "catherine@brightrace.com", "c-password", "regular"));

        given(userRepository.findAll()).willReturn(userList);

        User userExpected = userService.getByEmail(email);

        assertEquals(userExpected, userTest);

    }

}
