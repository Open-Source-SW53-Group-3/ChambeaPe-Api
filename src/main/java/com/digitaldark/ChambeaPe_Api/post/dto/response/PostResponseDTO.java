package com.digitaldark.ChambeaPe_Api.post.dto.response;

import com.digitaldark.ChambeaPe_Api.user.model.EmployerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDTO {
<<<<<<< Updated upstream
=======
    private int id;
>>>>>>> Stashed changes
    private String title;
    private String description;
    private String subtitle;
    private String imgUrl;
    private int employerId;
}
