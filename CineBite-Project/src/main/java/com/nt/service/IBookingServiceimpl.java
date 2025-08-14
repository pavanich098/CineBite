package com.nt.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Booking;
import com.nt.entity.FoodItem;
import com.nt.entity.User;
import com.nt.repository.BookingRepository;
import com.nt.repository.FoodItemRepository;
import com.nt.repository.UserRepository;
@Service
public class IBookingServiceimpl implements IBookingService 
{
	@Autowired
	private BookingRepository bookingrepo;
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private FoodItemRepository fitemrepo;

	@Override
	public Booking createBooking(int userid, int fooditem, int qty) 
	{
		User user=userrepo.findById(userid)
				.orElseThrow(()->new RuntimeException("User not found"));
		FoodItem fitem=fitemrepo
				.findById(fooditem).orElseThrow(()->new RuntimeException("Food item is not found"));
		Booking booking=new Booking();
		booking.setUser(user);
		booking.setFoodItem(fitem);
		booking.setBookingTime(LocalDateTime.now());
		booking.setQuantity(qty);
		booking.setTotalPrice(qty*fitem.getPrice());
		
		// TODO Auto-generated method stub
		 bookingrepo.save(booking);
		 return booking;
	}
	public List<Booking> getAllBookings() {
	    return bookingrepo.findAll();
	}


}
