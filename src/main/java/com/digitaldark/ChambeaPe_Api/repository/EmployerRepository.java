package com.digitaldark.ChambeaPe_Api.repository;

import com.digitaldark.ChambeaPe_Api.model.EmployerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerRepository extends JpaRepository<EmployerEntity, Long> {

    EmployerEntity findById(long id);
    List<EmployerEntity> findAll();
}
