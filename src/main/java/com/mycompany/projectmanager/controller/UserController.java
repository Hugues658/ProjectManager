package com.mycompany.projectmanager.controller;

import com.mycompany.projectmanager.dao.UserDAO;
import com.mycompany.projectmanager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {

        this.userDAO = userDAO;
    }

    @PostMapping(value = "/users/login")
    @Transactional
    public ResponseEntity<User> saveUser(@RequestBody User userData) {

        User user = userDAO.findByEmail(userData.getEmail());
        if (user.getPassword().equals(userData.getPassword()))
            return ResponseEntity.ok(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }


    @GetMapping("/findUsers")
    public ResponseEntity<List<User>> findUser() {
        List<User> users = userDAO.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/userSize")
    public ResponseEntity<Long> taskSize(){
        Long userSize = userDAO.usersSize();
        return new ResponseEntity<>(userSize,HttpStatus.OK);
    }
}
