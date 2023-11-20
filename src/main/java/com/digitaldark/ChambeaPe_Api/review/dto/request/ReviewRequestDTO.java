package com.digitaldark.ChambeaPe_Api.review.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDTO {
    private String description;
    private int sentById;
    private Timestamp date;
    private int rating;


}
