package com.digitaldark.ChambeaPe_Api.service;

import com.digitaldark.ChambeaPe_Api.dto.WorkerDTO;
import com.digitaldark.ChambeaPe_Api.model.WorkerEntity;

import java.util.List;

public interface WorkerService {
    public abstract WorkerEntity createWorker(WorkerEntity worker);
    public abstract List<WorkerEntity> getAllWorkers_v1();
    public abstract List<WorkerDTO> getAllWorkers();
    public abstract void deleteWorker(int id);
    public abstract void updateWorker(int id, WorkerDTO worker);
}
