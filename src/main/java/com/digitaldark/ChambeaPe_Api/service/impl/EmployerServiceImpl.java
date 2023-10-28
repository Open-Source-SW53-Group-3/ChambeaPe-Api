package com.digitaldark.ChambeaPe_Api.service.impl;

import com.digitaldark.ChambeaPe_Api.dto.EmployerDTO;
import com.digitaldark.ChambeaPe_Api.dto.WorkerDTO;
import com.digitaldark.ChambeaPe_Api.exception.ValidationException;
import com.digitaldark.ChambeaPe_Api.model.EmployerEntity;
import com.digitaldark.ChambeaPe_Api.model.UsersEntity;
import com.digitaldark.ChambeaPe_Api.repository.EmployerRepository;
import com.digitaldark.ChambeaPe_Api.repository.UserRepository;
import com.digitaldark.ChambeaPe_Api.service.EmployerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployerServiceImpl implements EmployerService {
  
    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private UserRepository userRepository;

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
                .map(employerEntity -> {
                    EmployerDTO employerDTO = modelMapper.map(employerEntity, EmployerDTO.class);
                    modelMapper.map(employerEntity.getUser(), employerDTO);
                    return employerDTO;
                })
                .collect(Collectors.toList());
        return employerDTOs;
    }

    @Override
    public void deleteEmployer(int id) {
        if (!employerRepository.existsById(id)) {
            throw new ValidationException("Employer does not exist");
        }

        employerRepository.deleteById(id);
        userRepository.deleteById(id);
    }

    @Override
    public void updateEmployer(int id, EmployerDTO employer) {
        EmployerEntity employerEntity = modelMapper.map(employerRepository.findById(id), EmployerEntity.class);
        //System.out.println("v1: "+employerEntity);
        modelMapper.map(employer, employerEntity);
        employerEntity.setId(id);

        // Obtiene la hora actual en milisegundos
        long currentTimeMillis = System.currentTimeMillis();

        // Crea un objeto Timestamp con la hora actual
        Timestamp timestamp = new Timestamp(currentTimeMillis);
        employerEntity.setDateCreated(timestamp);
        employerEntity.setDateUpdated(timestamp);

        //System.out.println(employerEntity);

        UsersEntity user = modelMapper.map(userRepository.findById(id), UsersEntity.class);
        //System.out.println("v1: "+user);
        modelMapper.map(employer, user);
        user.setId(id);
        //System.out.println(user);

        employerRepository.save(employerEntity);
        userRepository.save(user);
    }
}
