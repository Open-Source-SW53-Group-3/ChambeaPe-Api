package com.digitaldark.ChambeaPe_Api.service.impl;

import com.digitaldark.ChambeaPe_Api.dto.EmployerDTO;
import com.digitaldark.ChambeaPe_Api.model.EmployerEntity;
import com.digitaldark.ChambeaPe_Api.repository.EmployerRepository;
import com.digitaldark.ChambeaPe_Api.service.EmployerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployerServiceImpl implements EmployerService {
  
    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public EmployerEntity createEmployer(EmployerEntity employer) {
        return employerRepository.save(employer);
    }

    @Override
    public List<EmployerEntity> getAllEmployers_v1() {
        return employerRepository.findAll();
    }

    @Override
    public List<EmployerDTO> getAllEmployers() {
        List<EmployerEntity> employerEntities = employerRepository.findAll();

        // EmployerDTO las entidades en una lista de DTO en un solo paso
        List<EmployerDTO> employerDTOs = employerEntities
                .stream()
                .map(employerEntity -> modelMapper.map(employerEntity, EmployerDTO.class))
                .collect(Collectors.toList());
        return employerDTOs;
    }
}
