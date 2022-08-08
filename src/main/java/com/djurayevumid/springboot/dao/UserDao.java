package com.djurayevumid.springboot.dao;

import com.djurayevumid.springboot.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();
    public void saveUser(User user);
    public User getUser(int id);
    public void deleteUser(int id);

    public User updateUser(User user);

}
