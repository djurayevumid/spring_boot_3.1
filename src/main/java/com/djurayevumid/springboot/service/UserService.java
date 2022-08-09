package com.djurayevumid.springboot.service;


import com.djurayevumid.springboot.model.User;

import java.util.List;

public interface UserService {


    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public User updateUser(User user);

    public void deleteUser(int id);
}
