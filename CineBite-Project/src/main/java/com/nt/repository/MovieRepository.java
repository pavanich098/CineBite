package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
