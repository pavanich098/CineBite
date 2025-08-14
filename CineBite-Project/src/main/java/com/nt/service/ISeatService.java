package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Seat;

public interface ISeatService 
{
    Seat createSeat(Seat seat);
    Optional<Seat> getSeatById(int id);
    List<Seat> getAllSeats();
    Seat updateSeat(int id,Seat seat);
    void deleteSeat(int id);
}
