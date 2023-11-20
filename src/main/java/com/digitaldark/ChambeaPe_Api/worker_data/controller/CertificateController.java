package com.digitaldark.ChambeaPe_Api.worker_data.controller;


import com.digitaldark.ChambeaPe_Api.worker_data.dto.request.CertificateRequestDTO;
import com.digitaldark.ChambeaPe_Api.worker_data.dto.response.CertificateResponseDTO;

import com.digitaldark.ChambeaPe_Api.worker_data.service.CertificateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workers")
@CrossOrigin(origins = "*") // Puerto de Angular
public class CertificateController {
    @Autowired
    private CertificateService certificateService;

    //URL: http://localhost:8080/api/v1/users/{id}/certificates
    //Method: GET ALL
    @Transactional(readOnly = true)
    @GetMapping("/{id}/certificates")
    public ResponseEntity<List<CertificateResponseDTO>> getAllCertificatesByWorkerId(@PathVariable(value = "id") int userId) {
        return new ResponseEntity<List<CertificateResponseDTO>>(certificateService.getAllCertificatesByWorkerId(userId), HttpStatus.OK);
    }

    //Method : Post
    //URL: http://localhost:8080/api/v1/users/{id}/certificates
    @Transactional
    @PostMapping("/{id}/certificates")
    public ResponseEntity<CertificateResponseDTO> createCertificate(@RequestBody CertificateRequestDTO certificate, @PathVariable(value = "id") int userId) {
        return new ResponseEntity<CertificateResponseDTO>(certificateService.createCertificate(certificate, userId), HttpStatus.CREATED);
    }

    //method: Get
    //URL: http://localhost:8080/api/v1/users/{id}/certificates/{id}
    @Transactional(readOnly = true)
    @GetMapping("/{userId}/certificates/{certificateId}")
    public ResponseEntity<CertificateResponseDTO> getCertificateById(
            @PathVariable(value = "certificateId") int certificateId) {
        return new ResponseEntity<CertificateResponseDTO>(certificateService.getCertificateById(certificateId), HttpStatus.OK);
    }

    //method: Put
    //URL: http://localhost:8080/api/v1/users/{id}/certificates/{id}
    @Transactional
    @PutMapping("/{userId}/certificates/{certificateId}")
    public ResponseEntity<CertificateResponseDTO> updateCertificate(
            @PathVariable(value = "userId") int userId,
            @PathVariable(value = "certificateId") int certificateId,
            @RequestBody CertificateRequestDTO certificateDetails) {
        return new ResponseEntity<CertificateResponseDTO>(certificateService.updateCertificate(certificateId, certificateDetails), HttpStatus.OK);
    }

    //method: Delete
    //URL: http://localhost:8080/api/v1/users/{id}/certificates/{id}
    @Transactional
    @DeleteMapping("/{userId}/certificates/{certificateId}")
    public ResponseEntity<?> deleteCertificate(
            @PathVariable(value = "userId") int userId,
            @PathVariable(value = "certificateId") int certificateId) {
        certificateService.deleteCertificateById(certificateId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
