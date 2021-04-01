package com.sigma.usermanagement.controller;
import com.sigma.usermanagement.model.entities.User;
import com.sigma.usermanagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/user/management")
public class UserManagementController {

    private static Logger logger = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public void userList(){
        userService.userList();
        logger.info("List of users(Controller)");
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.createUser(user);
        logger.info("Creating user is complete(Controller)");
    }

    @PutMapping
    public void updateUser(@RequestBody User user){
       userService.updateUser(user);
        logger.info("Updating user is complete(Controller)");
    }

    @DeleteMapping
    @RequestMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        logger.info("Deleting user is complete(Controller)");
    }
}
