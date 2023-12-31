package com.digitaldark.ChambeaPe_Api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.digitaldark.ChambeaPe_Api.model.UsersEntity;

public interface UserRepository extends JpaRepository<UsersEntity, Long> {

    UsersEntity findById(long id);
    UsersEntity findByEmailAndPassword(String email, String password);
    List<UsersEntity> findAll();

    boolean existsById(long id);
    boolean existsByEmailAndPassword(String email, String password);
    boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);
}
