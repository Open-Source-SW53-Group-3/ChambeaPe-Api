package com.digitaldark.ChambeaPe_Api.service.impl;

import com.digitaldark.ChambeaPe_Api.dto.WorkerDTO;
import com.digitaldark.ChambeaPe_Api.exception.ValidationException;
import com.digitaldark.ChambeaPe_Api.model.UsersEntity;
import com.digitaldark.ChambeaPe_Api.model.WorkerEntity;
import com.digitaldark.ChambeaPe_Api.repository.UserRepository;
import com.digitaldark.ChambeaPe_Api.repository.WorkerRepository;
import com.digitaldark.ChambeaPe_Api.service.WorkerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public WorkerEntity createWorker(WorkerEntity worker) {
        return workerRepository.save(worker);
    }

    @Override
    public List<WorkerEntity> getAllWorkers_v1() {
        return workerRepository.findAll();
    }

    @Override
    public List<WorkerDTO> getAllWorkers() {
        List<WorkerEntity> workerEntities = workerRepository.findAll();

        // Convierte las entidades en una lista de DTO en un solo paso
        List<WorkerDTO> workerDTOs = workerEntities
                .stream()
                .map(workerEntity -> {
                    WorkerDTO workerDTO = modelMapper.map(workerEntity, WorkerDTO.class);
                    modelMapper.map(workerEntity.getUser(), workerDTO);
                    return workerDTO;
                })
                .collect(Collectors.toList());
        return workerDTOs;
    }

    @Override
    public void deleteWorker(int id) {
        if (!workerRepository.existsById(id)) {
            throw new ValidationException("Worker does not exist");
        }
        workerRepository.deleteById(id);
        userRepository.deleteById(id);
    }

    @Override
    public void updateWorker(int id, WorkerDTO worker) {
        WorkerEntity workerEntity = modelMapper.map(workerRepository.findById(id), WorkerEntity.class);
        modelMapper.map(worker, workerEntity);
        workerEntity.setId(id);
        // Obtiene la hora actual en milisegundos
        long currentTimeMillis = System.currentTimeMillis();

        // Crea un objeto Timestamp con la hora actual
        Timestamp timestamp = new Timestamp(currentTimeMillis);
        workerEntity.setDateCreated(timestamp);
        workerEntity.setDateUpdated(timestamp);


        UsersEntity user = modelMapper.map(userRepository.findById(id), UsersEntity.class);
        modelMapper.map(worker, user);
        user.setId(id);

        workerRepository.save(workerEntity);
        userRepository.save(user);
    }
}
