/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.movie.controller;

import com.example.movie.exception.ResourceNotFoundException;
import com.example.movie.model.Movie;
import com.example.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * endpoint
 * @author siti.syahirah
 */
@RestController
@RequestMapping("/movie/api")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @PostMapping("/movies")
    public Movie createMovie(@Valid @RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable(value = "id") Long movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId));
    }
    
    @PutMapping("/movies/{id}")
    public Movie updateMovie(@PathVariable(value = "id") Long movieId,
                                           @Valid @RequestBody Movie movieDetails) {

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId));

        movie.setTitle(movieDetails.getTitle());
        movie.setCategory(movieDetails.getCategory());
        movie.setRating(movieDetails.getRating());

        Movie updatedMovie = movieRepository.save(movie);
        return updatedMovie;
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable(value = "id") Long movieId) {
        Movie note = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId));

        movieRepository.delete(note);

        return ResponseEntity.ok().build();
    }

}
