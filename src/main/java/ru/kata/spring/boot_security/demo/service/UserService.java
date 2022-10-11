package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

    User getUser(int id);

    public void updateUser(int id, User user);

    public void deleteUser(int id);

    public UserDetails loadUserByUsername(String username);
}
