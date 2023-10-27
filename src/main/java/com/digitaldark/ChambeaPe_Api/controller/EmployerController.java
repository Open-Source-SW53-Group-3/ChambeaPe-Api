package com.digitaldark.ChambeaPe_Api.controller;

import com.digitaldark.ChambeaPe_Api.dto.EmployerDTO;
import com.digitaldark.ChambeaPe_Api.model.EmployerEntity;
import com.digitaldark.ChambeaPe_Api.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployerController {
   @Autowired
    private EmployerService employerService;

    //URL: http://localhost:8080/api/v1/workersV1
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/employersV1")
    public ResponseEntity<List<EmployerEntity>> getAllWorkers() {
        return new ResponseEntity<List<EmployerEntity>>(employerService.getAllEmployers_v1(), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/workers
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/employers")
    public ResponseEntity<List<EmployerDTO>> getAllWorkersDTO() {
        return new ResponseEntity<List<EmployerDTO>>(employerService.getAllEmployers(), HttpStatus.OK);
    }
}
