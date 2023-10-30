package com.digitaldark.ChambeaPe_Api.service.impl;

import com.digitaldark.ChambeaPe_Api.dto.worker.request.CertificateRequestDTO;
import com.digitaldark.ChambeaPe_Api.dto.worker.response.CertificateResponseDTO;
import com.digitaldark.ChambeaPe_Api.exception.ValidationException;
import com.digitaldark.ChambeaPe_Api.model.CertificatesEntity;
import com.digitaldark.ChambeaPe_Api.repository.UserRepository;
import com.digitaldark.ChambeaPe_Api.repository.WorkerRepository;
import com.digitaldark.ChambeaPe_Api.repository.worker.CertificateRepository;
import com.digitaldark.ChambeaPe_Api.service.CertificateService;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {
    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CertificateResponseDTO createCertificate(CertificateRequestDTO certificate, int id) {
        //UsersEntity userEntity = modelMapper.map(user, UsersEntity.class);
        System.out.println("El valor de Certificate: " + certificate);
        CertificatesEntity certificateEntity = modelMapper.map(certificate, CertificatesEntity.class);
        System.out.println("El valor de CertificateEntity: " + certificateEntity);


        // Obtiene la hora actual en milisegundos
        long currentTimeMillis = System.currentTimeMillis();

        // Crea un objeto Timestamp con la hora actual
        Timestamp timestamp = new Timestamp(currentTimeMillis);

        System.out.println("pasa el map");
        certificateEntity.setDateCreated(timestamp);
        certificateEntity.setDateUpdated(timestamp);
        certificateEntity.setWorker(workerRepository.findById(id));
        certificateEntity.setUserName(userRepository.findById(id).getFirstName()+" "+userRepository.findById(id).getLastName());
        certificateEntity.setIsActive((byte) 1);

        System.out.println("El valor de CertificateEntity es: " + certificateEntity);

        certificateRepository.save(certificateEntity);

        return modelMapper.map(certificateEntity,CertificateResponseDTO.class);
    }

    @Override
    public CertificatesEntity updateCertificate(int id, CertificatesEntity certificate) {
        return null;
    }

    @Override
    public void deleteCertificateById(int id) {
        certificateRepository.deleteById(id);
    }

    @Override
    public CertificateResponseDTO getCertificate(int id) {
        if(!certificateRepository.existsById(id)){
            throw new ValidationException("Certificate does not exist");
        }
        return modelMapper.map(certificateRepository.findById(id), CertificateResponseDTO.class);
    }

    @Override
    public List<CertificatesEntity> getAllCertificates() {
        return certificateRepository.findAll();
    }

    @Override
    public List<CertificatesEntity> getAllCertificatesByWorkerId(int id) {
        if(!certificateRepository.existsByWorkerId(id)){
            throw new ValidationException("Worker does not exist");
        }
        return certificateRepository.findAllByWorkerId(id);
    }
}
