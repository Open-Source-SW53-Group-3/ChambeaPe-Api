package com.digitaldark.ChambeaPe_Api.service;

import com.digitaldark.ChambeaPe_Api.dto.worker.request.CertificateRequestDTO;
import com.digitaldark.ChambeaPe_Api.dto.worker.response.CertificateResponseDTO;
import com.digitaldark.ChambeaPe_Api.model.CertificatesEntity;

import java.util.List;
public interface CertificateService {

    public abstract CertificateResponseDTO createCertificate(CertificateRequestDTO certificate, int id);
    public abstract CertificatesEntity updateCertificate(int id, CertificatesEntity certificate);
    public abstract void deleteCertificateById(int id);
    public abstract CertificateResponseDTO getCertificate(int id);
    public abstract List<CertificatesEntity> getAllCertificates();
    public abstract List<CertificatesEntity> getAllCertificatesByWorkerId(int id);
}
