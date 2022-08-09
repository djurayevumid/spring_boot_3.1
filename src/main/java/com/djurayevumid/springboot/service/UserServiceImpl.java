package com.djurayevumid.springboot.service;


import com.djurayevumid.springboot.dao.UserDao;
import com.djurayevumid.springboot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        User createdUser = getUser(user.getId());
        createdUser.setId(user.getId());
        createdUser.setName(user.getName());
        createdUser.setSurname(user.getSurname());
        createdUser.setDepartment(user.getDepartment());
        createdUser.setSalary(user.getSalary());
        return userDao.updateUser(createdUser);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
