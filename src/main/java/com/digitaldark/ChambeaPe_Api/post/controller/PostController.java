package com.digitaldark.ChambeaPe_Api.post.controller;

import com.digitaldark.ChambeaPe_Api.post.dto.request.PostRequestDTO;
import com.digitaldark.ChambeaPe_Api.post.dto.response.PostResponseDTO;
import com.digitaldark.ChambeaPe_Api.post.service.PostService;
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
public class PostController {
    @Autowired
    private PostService postService;

    //URL: http://localhost:8080/api/v1/posts
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/posts")
    public ResponseEntity<List<PostResponseDTO>> getAllPosts() {
        return new ResponseEntity<List<PostResponseDTO>>(postService.getAllPosts(), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/posts/{id}
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/posts/{id}")
    public ResponseEntity<PostResponseDTO> getPostById(@PathVariable("id") int id) {
        return new ResponseEntity<PostResponseDTO>(postService.getPostById(id), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/employers/{employerId}/posts
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/employers/{employerId}/posts")
    public ResponseEntity<List<PostResponseDTO>> getAllPostsByEmployerId(@PathVariable("employerId") int employerId) {
        return new ResponseEntity<List<PostResponseDTO>>(postService.getAllPostsByEmployerId(employerId), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/employers/{employerId}/posts
    //Method: POST
    @Transactional
    @PostMapping("employers/{employerId}/posts")
    public ResponseEntity<PostResponseDTO> createPost(@RequestBody PostRequestDTO post, @PathVariable("employerId") int employerId) {
        return new ResponseEntity<PostResponseDTO>(postService.createPost(post, employerId), HttpStatus.CREATED);
    }

    //URL: http://localhost:8080/api/v1/posts/{id}
    //Method: DELETE
    @Transactional
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Object> deletePost( @PathVariable("id") int id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/posts/{id}
    //Method: PUT
    @Transactional
    @PutMapping("/posts/{id}")
    public ResponseEntity<Object> updatePost(@PathVariable("id") int id, @RequestBody PostRequestDTO post) {
        postService.updatePost(id, post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
