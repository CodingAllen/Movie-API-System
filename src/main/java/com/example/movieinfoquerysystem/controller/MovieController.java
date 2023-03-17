package com.example.movieinfoquerysystem.controller;

import com.example.movieinfoquerysystem.service.MovieService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movie/{id}")
    public ResponseEntity<String> getMovieById(@PathVariable("id") int id) {
        try {
            JsonObject movieObject = movieService.getMovieById(id);
            return new ResponseEntity<>(movieObject.toString(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error fetching movie information.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/title/{title}")
    public ResponseEntity<String> searchMoviesByTitle(@PathVariable("title") String title) {
        try {
            JsonObject searchResults = movieService.searchMoviesByTitle(title);
            return new ResponseEntity<>(searchResults.toString(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error fetching movie information.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/search/release_date/{start_date}/{end_date}")
    public ResponseEntity<String> searchMoviesByReleaseDate(@PathVariable("start_date") String startDate, @PathVariable("end_date") String endDate) {
        try {
            JsonObject searchResults = movieService.searchMoviesByReleaseDate(startDate, endDate);
            return new ResponseEntity<>(searchResults.toString(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error fetching movie information.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/overview/{overview}")
    public ResponseEntity<String> searchMoviesByOverview(@PathVariable("overview") String overview) {
        try {
            JsonObject searchResults = movieService.searchMoviesByOverview(overview);
            return new ResponseEntity<>(searchResults.toString(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error fetching movie information.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/keyword/{keyword}")
    public ResponseEntity<String> searchMoviesByKeyword(@PathVariable("keyword") String keyword) {
        try {
            JsonObject searchResults = movieService.searchMoviesByKeyword(keyword);
            return new ResponseEntity<>(searchResults.toString(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error fetching movie information.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






}
