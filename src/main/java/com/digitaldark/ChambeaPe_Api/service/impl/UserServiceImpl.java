package com.digitaldark.ChambeaPe_Api.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.digitaldark.ChambeaPe_Api.dto.UserDTO;
import com.digitaldark.ChambeaPe_Api.model.WorkerEntity;
import com.digitaldark.ChambeaPe_Api.service.WorkerService;
import org.modelmapper.ModelMapper;
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
    private ModelMapper modelMapper;

    @Autowired
    private WorkerService workerService;

    @Override
    public UsersEntity createUser(UsersEntity user) {
        if (userRepository.existsById(user.getId())) {
            throw new ValidationException("User already exists");
        } else if (userRepository.existsByEmailOrPhoneNumber(user.getEmail(), user.getPhoneNumber())) {
            throw new ValidationException("Email or phone number already exists");
        } else if (!"M".equals(user.getGender()) && !"F".equals(user.getGender())) {
            throw new ValidationException("Gender is invalid");
        }

        userRepository.save(user);

        if ("E".equals(user.getUserRole())) {
            EmployerEntity employer = modelMapper.map(user, EmployerEntity.class);
            employer.setUser(user);
            System.out.println("El valor de user es: " + employer);

            employerService.createEmployer(employer);
        } else if ("W".equals(user.getUserRole())) {
            WorkerEntity worker = modelMapper.map(user, WorkerEntity.class);
            worker.setOccupation("");
            worker.setUser(user);
            System.out.println("El valor de user es: " + worker);
            workerService.createWorker(worker);
        } else {
            throw new ValidationException("userRole is invalid");
        }

        return user;
    }

    @Override
    public UserDTO createUserDTO(UserDTO user) {
        if (userRepository.existsById(user.getId())) {
            throw new ValidationException("User already exists");
        } else if (userRepository.existsByEmailOrPhoneNumber(user.getEmail(), user.getPhoneNumber())) {
            throw new ValidationException("Email or phone number already exists");
        }

        // Obtiene la hora actual en milisegundos
        long currentTimeMillis = System.currentTimeMillis();

        // Crea un objeto Timestamp con la hora actual
        Timestamp timestamp = new Timestamp(currentTimeMillis);

        UsersEntity userEntity = modelMapper.map(user, UsersEntity.class);
        userEntity.setHasPremium( (byte) 0);
        userEntity.setIsActive( (byte) 1);
        userEntity.setDateCreated(timestamp);
        userEntity.setDateUpdated(timestamp);


        userRepository.save(userEntity);

        if ("E".equals(userEntity.getUserRole())) {
            EmployerEntity employer = modelMapper.map(userEntity, EmployerEntity.class);
            employer.setUser(userEntity);
            System.out.println("El valor de user es: " + employer);

            employerService.createEmployer(employer);
        } else if ("W".equals(userEntity.getUserRole())) {
            WorkerEntity worker = modelMapper.map(userEntity, WorkerEntity.class);
            worker.setOccupation("");
            worker.setUser(userEntity);
            System.out.println("El valor de user es: " + worker);
            workerService.createWorker(worker);
        } else {
            throw new ValidationException("userRole is invalid");
        }

        return user;
    }

    @Override
    public UsersEntity getUser(int id) {
        if (!userRepository.existsById(id)) {
            throw new ValidationException("User does not exist");
        }

        return userRepository.findById(id);
    }

    @Override
    public List<UsersEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDTO getUserEmailAndPass(String email, String password) {
        if (!userRepository.existsByEmailAndPassword(email, password)) {
            throw new ValidationException("Email or password is incorrect");
        }
        UsersEntity user = userRepository.findByEmailAndPassword(email, password);

        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(int id, UsersEntity user) {
        if (!userRepository.existsById(id)) {
            throw new ValidationException("User does not exist");
        }

        userRepository.save(user);
    }


}