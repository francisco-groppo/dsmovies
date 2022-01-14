package com.devsuperior.dsmovies.repositories;

import com.devsuperior.dsmovies.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
