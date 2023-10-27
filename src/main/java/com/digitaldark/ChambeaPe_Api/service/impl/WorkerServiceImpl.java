package com.digitaldark.ChambeaPe_Api.service.impl;

import com.digitaldark.ChambeaPe_Api.dto.WorkerDTO;
import com.digitaldark.ChambeaPe_Api.model.WorkerEntity;
import com.digitaldark.ChambeaPe_Api.repository.WorkerRepository;
import com.digitaldark.ChambeaPe_Api.service.WorkerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

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
}
