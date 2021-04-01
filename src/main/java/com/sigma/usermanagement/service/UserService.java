package com.sigma.usermanagement.service;
import com.sigma.usermanagement.model.entities.User;

public interface UserService {

    void updateUser(User user);

    void createUser(User user);

    void deleteUser(Long id);

    void userList();
}
