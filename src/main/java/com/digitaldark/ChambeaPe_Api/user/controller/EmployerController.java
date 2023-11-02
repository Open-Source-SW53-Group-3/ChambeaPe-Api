package com.digitaldark.ChambeaPe_Api.user.controller;

import com.digitaldark.ChambeaPe_Api.user.dto.EmployerDTO;
import com.digitaldark.ChambeaPe_Api.user.model.EmployerEntity;
import com.digitaldark.ChambeaPe_Api.user.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200") // Puerto de Angular
public class EmployerController {
   @Autowired
    private EmployerService employerService;

    //URL: http://localhost:8080/api/v1/employersV1
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/employersV1")
    public ResponseEntity<List<EmployerEntity>> getAllEmployers() {
        return new ResponseEntity<List<EmployerEntity>>(employerService.getAllEmployers_v1(), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/employers
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/employers")
    public ResponseEntity<List<EmployerDTO>> getAllEmployersDTO() {
        return new ResponseEntity<List<EmployerDTO>>(employerService.getAllEmployers(), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/employers/{id}
    //Method: DELETE
    @Transactional
    @DeleteMapping("/employers/{id}")
    public ResponseEntity<Object> deleteEmployer(@PathVariable("id") int id) {
        employerService.deleteEmployer(id);
        return new ResponseEntity<>("Employer was deleted successfully",HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/employers/{id}
    //Method: PUT
    @Transactional
    @PutMapping("/employers/{id}")
    public ResponseEntity<Object> updateEmployer(@PathVariable("id") int id, @RequestBody EmployerDTO employer) {
        employerService.updateEmployer(id, employer);
        return new ResponseEntity<>("Employer was updated successfully",HttpStatus.OK);
    }
}
