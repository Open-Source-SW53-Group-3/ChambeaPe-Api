package com.digitaldark.ChambeaPe_Api.user.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.digitaldark.ChambeaPe_Api.user.model.UsersEntity;

public interface UserRepository extends JpaRepository<UsersEntity, Integer> {

    UsersEntity findById(int id);
    UsersEntity findByEmailAndPassword(String email, String password);

    List<UsersEntity> findAll();

    boolean existsById(int id);
    boolean existsByEmailAndPassword(String email, String password);
    boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);
}
