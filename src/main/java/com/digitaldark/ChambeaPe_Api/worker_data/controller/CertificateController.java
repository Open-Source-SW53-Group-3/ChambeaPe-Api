package com.digitaldark.ChambeaPe_Api.worker_data.controller;


import com.digitaldark.ChambeaPe_Api.worker_data.dto.request.CertificateRequestDTO;
import com.digitaldark.ChambeaPe_Api.worker_data.dto.response.CertificateResponseDTO;
import com.digitaldark.ChambeaPe_Api.worker_data.model.CertificatesEntity;
import com.digitaldark.ChambeaPe_Api.worker_data.service.CertificateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CertificateController {
    @Autowired
    private CertificateService certificateService;

    //URL: http://localhost:8080/api/v1/users/{id}/certificates
    //Method: GET ALL
    @Transactional(readOnly = true)
    @GetMapping("/users/{id}/certificates")
    public ResponseEntity<List<CertificatesEntity>> getAllCertificatesByUser(@PathVariable(value = "id") int userId) {
        return new ResponseEntity<List<CertificatesEntity>>(certificateService.getAllCertificatesByWorkerId(userId), HttpStatus.OK);
    }

    //Method : Post
    //URL: http://localhost:8080/api/v1/users/{id}/certificates
    @Transactional
    @PostMapping("/users/{id}/certificates")
    public ResponseEntity<CertificateResponseDTO> createCertificate(@RequestBody CertificateRequestDTO certificate, @PathVariable(value = "id") int userId) {
        return new ResponseEntity<CertificateResponseDTO>(certificateService.createCertificate(certificate, userId), HttpStatus.CREATED);
    }

}
