package com.digitaldark.ChambeaPe_Api.user.controller;

import com.digitaldark.ChambeaPe_Api.user.dto.request.UserLoginDTO;
import com.digitaldark.ChambeaPe_Api.user.dto.request.UserRequestDTO;
import com.digitaldark.ChambeaPe_Api.user.dto.response.UserResponseDTO;
import com.digitaldark.ChambeaPe_Api.user.model.UsersEntity;
import com.digitaldark.ChambeaPe_Api.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:4200") // Puerto de Angular
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;
    
    //URL: http://localhost:8080/api/v1/users
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        return new ResponseEntity<List<UserResponseDTO>>(userService.getAllUsers(), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/users/login
    //Method: GET
    @Transactional(readOnly = true)
    @PostMapping("/users/login")
    public ResponseEntity<UserResponseDTO> getUserByEmailAndPass(@RequestBody UserLoginDTO userLoginDTO) {
        return new ResponseEntity<UserResponseDTO>(userService.getUserEmailAndPass(userLoginDTO), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/users
    //Method: POST
    @Transactional
    @PostMapping("/usersv1")
    public ResponseEntity<UsersEntity> createUser(@RequestBody UsersEntity user) {

        System.out.println("Se creo un usuario" + user);

        return new ResponseEntity<UsersEntity>(userService.createUser(user), HttpStatus.CREATED);
    }

    //URL: http://localhost:8080/api/v1/users
    //Method: POST
    @Transactional
    @PostMapping("/users")
    public ResponseEntity<UserResponseDTO> createUserDTO(@RequestBody UserRequestDTO user) {

        System.out.println("Se creo un usuario: " + user);

        return new ResponseEntity<UserResponseDTO>(userService.createUserDTO(user), HttpStatus.CREATED);
    }



    
}
