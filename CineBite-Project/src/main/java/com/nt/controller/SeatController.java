package com.nt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Seat;
import com.nt.service.ISeatService;

@RestController
@RequestMapping("/api/seats")
public class SeatController 
{
   @Autowired
   private ISeatService service;
   
   @PostMapping("/create")
   public Seat createSeat(@RequestBody Seat seat)
   {
	   return service.createSeat(seat);
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Seat> getSeatById(@PathVariable int id) {
       Optional<Seat> seat = service.getSeatById(id);
       return seat.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
   }

   
   @GetMapping("/all")
   public List<Seat> getAllSeats()
   {
	   return service.getAllSeats();
   }
   
   @PutMapping("/update/{id}")
   public Seat updateseatNumber(@PathVariable int id,@RequestBody Seat seat)
   {
	   return service.updateSeat(id, seat);
   }
   @DeleteMapping("/delete/{id}")
   public void deleteSeat(@PathVariable int id)
   {
	   service.deleteSeat(id);
   }
}
