package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Movie;
import com.nt.repository.MovieRepository;
@Service
public class IMovieImplService implements IMovieService 
{
     @Autowired
     private MovieRepository repo;
	@Override
	public List<Movie> getAllMovies() 
	{
    	 
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Movie addMovie(Movie movie) 
	{
		// TODO Auto-generated method stub
		return repo.save(movie);
	}

}
