package com.example.buoi2_jpa.controller;

import com.example.buoi2_jpa.model.MissQueen;
import com.example.buoi2_jpa.repository.MissQueenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MissQueenController {
    @Autowired
    private MissQueenRepository missQueenRepository;

    @GetMapping(value = "/queen/all")
    public ResponseEntity<List<MissQueen>> getAllQueen(){
        List<MissQueen> missQueens = missQueenRepository.
                findAllByNameAndHeight(178, "Tien");
        return ResponseEntity.ok(missQueens);
    }
}
