package com.digitaldark.ChambeaPe_Api.repository.worker;

import com.digitaldark.ChambeaPe_Api.model.CertificatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CertificateRepository extends JpaRepository<CertificatesEntity, Integer> {

    CertificatesEntity findByName(String name );
    boolean existsByWorkerId(int id);
    List<CertificatesEntity> findAllByWorkerId(int id);

}
