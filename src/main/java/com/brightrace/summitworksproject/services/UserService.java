package com.brightrace.summitworksproject.services;

import javax.transaction.Transactional;

import com.brightrace.summitworksproject.model.User;
import com.brightrace.summitworksproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> listAll() { return repository.findAll(); }
    public User get(Integer id) {
        return repository.findById(id).get();
    }
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public void save(User user) {

        // B-Crypt code
        PasswordEncoder passwordEncoder;
        passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        repository.save(user);

    }

    public User getByUsername(String username) {

        ArrayList<User> allUsers = new ArrayList<>(repository.findAll());

        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getEmail().equals(username)) {
                return allUsers.get(i);
            }
        }

        System.out.println("UserService[0]");
        return null;

    }

}
