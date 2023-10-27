package com.digitaldark.ChambeaPe_Api.service;

import java.util.List;

import com.digitaldark.ChambeaPe_Api.model.UsersEntity;

public interface UserService {
    public abstract UsersEntity createUser(UsersEntity user);
    public abstract UsersEntity getUserEmailAndPass(String email, String password);
    public abstract List<UsersEntity> getAllUsers();
}
