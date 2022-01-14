package com.devsuperior.dsmovies.controllers;

import com.devsuperior.dsmovies.dto.MovieDTO;
import com.devsuperior.dsmovies.dto.ScoreDTO;
import com.devsuperior.dsmovies.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
        return scoreService.saveScore(dto);
    }
}
