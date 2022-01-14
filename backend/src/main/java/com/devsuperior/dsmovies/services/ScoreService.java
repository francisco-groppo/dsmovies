package com.devsuperior.dsmovies.services;

import com.devsuperior.dsmovies.dto.MovieDTO;
import com.devsuperior.dsmovies.dto.ScoreDTO;
import com.devsuperior.dsmovies.entities.Movie;
import com.devsuperior.dsmovies.entities.Score;
import com.devsuperior.dsmovies.entities.User;
import com.devsuperior.dsmovies.repositories.MovieRepository;
import com.devsuperior.dsmovies.repositories.ScoreRepository;
import com.devsuperior.dsmovies.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {

        User user = userRepository.findByEmail(dto.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        scoreRepository.saveAndFlush(score);

        Double meanScore =
                movie.getScores().stream().mapToDouble(Score::getValue).sum()
                / movie.getScores().size();

        movie.setScore(meanScore);
        movie.setCount(movie.getScores().size());

        return new MovieDTO(movieRepository.save(movie));
    }
}
