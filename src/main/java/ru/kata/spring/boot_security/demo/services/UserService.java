package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

    User getUser(int id);

    public void updateUser(int id, User user);

    public void deleteUser(int id);

    public User findByUsername(String username);


}
