package com.digitaldark.ChambeaPe_Api.postulation.controller;

import com.digitaldark.ChambeaPe_Api.postulation.dto.request.PostulationRequestDTO;
import com.digitaldark.ChambeaPe_Api.postulation.dto.response.PostulationResponseDTO;
import com.digitaldark.ChambeaPe_Api.postulation.service.PostulationService;
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
public class PostulationController {
    @Autowired
    private PostulationService postulationService;

    //URL: http://localhost:8080/api/v1/posts/{postId}/postulations
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/posts/{postId}/postulations")
    public ResponseEntity<List<PostulationResponseDTO>> getAllPostulationsByPost(@PathVariable("postId") int postId) {
        return new ResponseEntity<List<PostulationResponseDTO>>(postulationService.getAllPostulationsByPost(postId), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/posts/{postId}/postulations/{workerId}
    //Method: POST
    @Transactional
    @PostMapping("/posts/{postId}/postulations/{workerId}")
    public ResponseEntity<PostulationResponseDTO> createPostulation(@PathVariable("postId") int postId, @PathVariable("workerId") int workerId, @RequestBody PostulationRequestDTO postulation) {
        return new ResponseEntity<PostulationResponseDTO>(postulationService.createPostulation(postId, workerId,postulation), HttpStatus.CREATED);
    }

    //URL: http://localhost:8080/api/v1/posts/{postId}/postulations
    //Method: DELETE
    @Transactional
    @DeleteMapping("/posts/{postId}/postulations/{workerId}")
    public ResponseEntity<Object> deletePostulation(@PathVariable("postId") int postId, @PathVariable("workerId") int workerId) {
        postulationService.deletePostulation(postId, workerId);
        //return new ResponseEntity<Object>("Postulation deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/postulations/{id}
    //Method: PUT
    @Transactional
    @PutMapping("/postulations/{id}")
    public ResponseEntity<Object> updatePostulation( @PathVariable("id") int id) {
        postulationService.updatePostulation(id);
        return new ResponseEntity<>("Postulation was updated successfully",HttpStatus.OK);
    }
}
