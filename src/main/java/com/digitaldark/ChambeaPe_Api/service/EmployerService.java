package com.digitaldark.ChambeaPe_Api.service;

import com.digitaldark.ChambeaPe_Api.dto.EmployerDTO;
import com.digitaldark.ChambeaPe_Api.model.EmployerEntity;

import java.util.List;

public interface EmployerService {
    public abstract EmployerEntity createEmployer(EmployerEntity employer);
    public abstract List<EmployerEntity> getAllEmployers_v1();

    public abstract List<EmployerDTO> getAllEmployers();
}
