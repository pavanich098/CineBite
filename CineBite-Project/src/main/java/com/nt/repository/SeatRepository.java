package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

}
