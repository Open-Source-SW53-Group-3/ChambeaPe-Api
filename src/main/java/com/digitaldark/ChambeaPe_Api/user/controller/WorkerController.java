package com.digitaldark.ChambeaPe_Api.user.controller;

import com.digitaldark.ChambeaPe_Api.user.dto.WorkerDTO;
import com.digitaldark.ChambeaPe_Api.user.model.WorkerEntity;
import com.digitaldark.ChambeaPe_Api.user.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    //URL: http://localhost:8080/api/v1/workersV1
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/workersV1")
    public ResponseEntity<List<WorkerEntity>> getAllWorkers() {
        return new ResponseEntity<List<WorkerEntity>>(workerService.getAllWorkers_v1(), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/workers
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/workers")
    public ResponseEntity<List<WorkerDTO>> getAllWorkersDTO() {
        return new ResponseEntity<List<WorkerDTO>>(workerService.getAllWorkers(), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/workers/{id}
    //Method: DELETE
    @Transactional
    @DeleteMapping("/workers/{id}")
    public ResponseEntity<Object> deleteWorker(@PathVariable("id") int id) {
        workerService.deleteWorker(id);
        return new ResponseEntity<>("Worker was deleted successfully",HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/workers/{id}
    //Method: PUT
    @Transactional
    @PutMapping("/workers/{id}")
    public ResponseEntity<Object> updateWorker(@PathVariable("id") int id, @RequestBody WorkerDTO worker) {
        workerService.updateWorker(id, worker);
        return new ResponseEntity<>("Worker was updated successfully",HttpStatus.OK);
    }
}
