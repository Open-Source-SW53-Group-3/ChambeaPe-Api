package com.digitaldark.ChambeaPe_Api.service.impl;

import java.util.List;

import com.digitaldark.ChambeaPe_Api.model.WorkerEntity;
import com.digitaldark.ChambeaPe_Api.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitaldark.ChambeaPe_Api.exception.ValidationException;
import com.digitaldark.ChambeaPe_Api.model.EmployerEntity;
import com.digitaldark.ChambeaPe_Api.model.UsersEntity;
import com.digitaldark.ChambeaPe_Api.repository.UserRepository;
import com.digitaldark.ChambeaPe_Api.service.EmployerService;
import com.digitaldark.ChambeaPe_Api.service.UserService;

@Service
public class UserServiceImpl implements UserService {
   
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployerService employerService;

    @Autowired
    private WorkerService workerService;

    @Override
    public UsersEntity createUser(UsersEntity user) {
        if (userRepository.existsById(user.getId())) {
            throw new ValidationException("User already exists");
        } else if (userRepository.existsByEmailOrPhoneNumber(user.getEmail(), user.getPhoneNumber())) {
            throw new ValidationException("Email or phone number already exists");
        }

        userRepository.save(user);

        if ("E".equals(user.getUserRole())) {
            EmployerEntity employer = new EmployerEntity();
            employer.setUser(user);
            employer.setId(user.getId());
            employer.setDateCreated(user.getDateCreated());
            employer.setDateUpdated(user.getDateUpdated());
            employer.setIsActive(user.getIsActive());
            employerService.createEmployer(employer);
        } else if ("W".equals(user.getUserRole())) {
            WorkerEntity worker = new WorkerEntity();
            worker.setUser(user);
            worker.setId(user.getId());
            worker.setDateCreated(user.getDateCreated());
            worker.setDateUpdated(user.getDateUpdated());
            worker.setIsActive(user.getIsActive());
            worker.setOccupation("");

            workerService.createWorker(worker);
        } else {
            throw new ValidationException("userRole is invalid");
        }


        return user;
    }

    @Override
    public List<UsersEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UsersEntity getUserEmailAndPass(String email, String password) {
        if (!userRepository.existsByEmailAndPassword(email, password)) {
            throw new ValidationException("Email or password is incorrect");
        }

        return userRepository.findByEmailAndPassword(email, password);
    }
}