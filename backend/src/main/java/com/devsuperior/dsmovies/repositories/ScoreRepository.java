package com.devsuperior.dsmovies.repositories;

import com.devsuperior.dsmovies.entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
