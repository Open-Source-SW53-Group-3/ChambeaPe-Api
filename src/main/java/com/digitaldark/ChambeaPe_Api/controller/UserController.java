package com.digitaldark.ChambeaPe_Api.controller;


import com.digitaldark.ChambeaPe_Api.model.UsersEntity;
import com.digitaldark.ChambeaPe_Api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;
    
    //URL: http://localhost:8080/api/v1/users
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/users")
    public ResponseEntity<List<UsersEntity>> getUsers() {
        return new ResponseEntity<List<UsersEntity>>(userService.getAllUsers(), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/users
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/users/login")
    public ResponseEntity<UsersEntity> getUserByEmailAndPass(@RequestParam("email") String email, @RequestParam("password") String password) {
        return new ResponseEntity<UsersEntity>(userService.getUserEmailAndPass(email, password), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/users
    //Method: POST
    @Transactional
    @PostMapping("/users")
    public ResponseEntity<UsersEntity> createUser(@RequestBody UsersEntity user) {

        System.out.println("Se creo un usuario" + user);

        return new ResponseEntity<UsersEntity>(userService.createUser(user), HttpStatus.CREATED);
    }



    
}
