package com.digitaldark.ChambeaPe_Api.service;

import java.util.List;

import com.digitaldark.ChambeaPe_Api.dto.UserDTO;
import com.digitaldark.ChambeaPe_Api.model.UsersEntity;

public interface UserService {
    public abstract UsersEntity getUser(int id);
    public abstract UsersEntity createUser(UsersEntity user);
    public abstract UserDTO createUserDTO(UserDTO user);
    public abstract UserDTO getUserEmailAndPass(String email, String password);
    public abstract List<UsersEntity> getAllUsers();
    public abstract void deleteUser(int id);
    public abstract void updateUser(int id, UsersEntity user);
}
