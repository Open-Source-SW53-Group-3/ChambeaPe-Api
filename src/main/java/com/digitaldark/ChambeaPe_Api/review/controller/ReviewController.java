package com.digitaldark.ChambeaPe_Api.review.controller;

import com.digitaldark.ChambeaPe_Api.review.dto.request.ReviewRequestDTO;
import com.digitaldark.ChambeaPe_Api.review.dto.response.ReviewResponseDTO;
import com.digitaldark.ChambeaPe_Api.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:4200") // Puerto de Angular
@CrossOrigin(origins = "*")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Transactional(readOnly = true)
    @GetMapping("/workers/{id}/reviews")
    public ResponseEntity<List<ReviewResponseDTO>> getAllReviewsByWorkerId(@PathVariable(value = "id") int id) {
        return new ResponseEntity<List<ReviewResponseDTO>>(reviewService.getAllReviewsByWorkerId(id), HttpStatus.OK);
    }

    //crear una review
    @Transactional
    @PostMapping("/workers/{id}/reviews")
    public ResponseEntity<ReviewResponseDTO> createReview(@RequestBody ReviewRequestDTO review, @PathVariable(value = "id") int id) {
        return new ResponseEntity<ReviewResponseDTO>(reviewService.createReview(review, id), HttpStatus.CREATED);
    }

}
