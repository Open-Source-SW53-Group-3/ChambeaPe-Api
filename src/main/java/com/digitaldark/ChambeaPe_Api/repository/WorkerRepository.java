package com.digitaldark.ChambeaPe_Api.repository;

import com.digitaldark.ChambeaPe_Api.model.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerRepository extends JpaRepository<WorkerEntity, Long> {

    WorkerEntity findById(long id);
    List<WorkerEntity> findAll();
}
