package com.djurayevumid.springboot.dao;

import com.djurayevumid.springboot.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public User updateUser(User user) {
        User createdUser = getUser(user.getId());
        createdUser.setId(user.getId());
        createdUser.setName(user.getName());
        createdUser.setSurname(user.getSurname());
        createdUser.setDepartment(user.getDepartment());
        createdUser.setSalary(user.getSalary());
        return entityManager.merge(createdUser);
    }
}

