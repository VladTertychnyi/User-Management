package com.sigma.usermanagement.service.Impl;
import com.sigma.usermanagement.model.entities.User;
import com.sigma.usermanagement.repository.UserRepository;
import com.sigma.usermanagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public void updateUser(User updateUser) {
        Long id = updateUser.getId();
        User user = userRepository.findById(id).orElseThrow();
        user.setFirstName(updateUser.getFirstName());
        user.setLastName(updateUser.getLastName());
        user.setDateOfBirth(updateUser.getDateOfBirth());
        user.setLogin(updateUser.getLogin());
        user.setPassword(updateUser.getPassword());
        user.setInputField(updateUser.getInputField());
        user.setAddress(updateUser.getAddress());
        userRepository.save(user);
        logger.info("Updating user is complete(Service)");
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
        logger.info("Creating user is complete(Service)");
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        logger.info("Deleting user is complete(Service)");
    }

    @Override
    public void userList() {
        userRepository.findAll();
        logger.info("List of users(Service)");
    }
}
