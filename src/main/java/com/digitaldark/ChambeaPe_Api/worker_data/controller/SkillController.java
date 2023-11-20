package com.digitaldark.ChambeaPe_Api.worker_data.controller;


import com.digitaldark.ChambeaPe_Api.worker_data.dto.request.SkillRequestDTO;
import com.digitaldark.ChambeaPe_Api.worker_data.dto.response.SkillResponseDTO;
import com.digitaldark.ChambeaPe_Api.worker_data.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workers")
@CrossOrigin(origins = "*")
public class SkillController {
    @Autowired
    private SkillService skillService;

    //URL: http://localhost:8080/api/v1/workers/{id}/skills
    //Method: GET ALL
    @Transactional(readOnly = true)
    @GetMapping("/{id}/skills")
    public ResponseEntity<List<SkillResponseDTO>> getAllSkillsByWorkerId(@PathVariable(value = "id") int userId) {
        return new ResponseEntity<List<SkillResponseDTO>>(skillService.getAllSkillsByWorkerId(userId), HttpStatus.OK);
    }

    //method: Post
    //URL: http://localhost:8080/api/v1/workers/{id}/skills
    @Transactional
    @PostMapping("/{id}/skills")
    public ResponseEntity<SkillResponseDTO> createSkill(@RequestBody SkillRequestDTO skill, @PathVariable(value = "id") int userId) {
        return new ResponseEntity<SkillResponseDTO>(skillService.createSkill(skill, userId), HttpStatus.CREATED);
    }

    //method: Delete
    //URL: http://localhost:8080/api/v1/workers/{id}/skills/{id}
    @Transactional
    @DeleteMapping("/{userId}/skills/{skillId}")
    public ResponseEntity<SkillResponseDTO> deleteSkill(
            @PathVariable(value = "userId") int userId,
            @PathVariable(value = "skillId") int skillId) {

        skillService.deleteSkillById(skillId);
        return new ResponseEntity<SkillResponseDTO>(HttpStatus.OK);
    }



}
