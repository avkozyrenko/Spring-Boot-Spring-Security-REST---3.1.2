package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public User getUser(int id);

    public void addUser(User user);

    public User findByUsername(String username);

    public void updateUser(int id, User user);

    public void deleteUser(int id);
}
