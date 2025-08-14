package com.nt.service;

import com.nt.entity.Booking;

public interface IBookingService 
{
     public Booking createBooking(int userid,int fooditem,int qty);
}
