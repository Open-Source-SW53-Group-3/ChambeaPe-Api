package com.digitaldark.ChambeaPe_Api.dto.worker.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificateRequestDTO {

    private String certificateName;
    private String imgUrl;
    private String institutionName;
    private String teacherName;
    private Timestamp issueDate;
    private String CertificateName;
}
