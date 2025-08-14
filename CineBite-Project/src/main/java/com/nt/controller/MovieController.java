package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.Movie;
import com.nt.service.IMovieImplService;

@RestController
//@RequestMapping("/movies")
public class MovieController 
{
   @Autowired
   private IMovieImplService service;
   
   @GetMapping
   public List<Movie> getAllMovies() {
       return service.getAllMovies();
   }

   @PostMapping
   public Movie addMovie(@RequestBody Movie movie,@RequestParam MultipartFile file) {
       return service.addMovie(movie);
   }
   
}