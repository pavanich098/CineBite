package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Booking;
import com.nt.service.IBookingServiceimpl;

@RestController
@RequestMapping("/api/bookings")
public class BookingController 
{
    @Autowired
    private IBookingServiceimpl service;
    //create booking
    @GetMapping("/create")
    public ResponseEntity<?> createbooking(
    		@RequestParam int userid,
    		@RequestParam int fooditem,
    		@RequestParam int qty)
    {
    	try {
    		Booking booking = service.createBooking(userid, fooditem, qty);
    		return new ResponseEntity<Booking>(booking,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(""+e.getMessage(),HttpStatus.OK);
		}
    
    	

    }
    
    @GetMapping("/fetch")
    public List<Booking> getAllBookings()
    {
    	return service.getAllBookings();
    }
}
