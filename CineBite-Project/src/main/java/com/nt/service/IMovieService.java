package com.nt.service;

import java.util.List;

import com.nt.entity.Movie;

public interface IMovieService 
{
	List<Movie> getAllMovies();
    Movie addMovie(Movie movie);
}
