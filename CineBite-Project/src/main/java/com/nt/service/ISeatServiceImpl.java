package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Seat;
import com.nt.repository.SeatRepository;
@Service
public class ISeatServiceImpl implements ISeatService {
     @Autowired
     private SeatRepository repo;
	@Override
	public Seat createSeat(Seat seat) {
		// TODO Auto-generated method stub
		return repo.save(seat);
	}

	@Override
	public Optional<Seat> getSeatById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Seat> getAllSeats() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Seat updateSeat(int id, Seat seat) {
		// TODO Auto-generated method stub
		Optional<Seat> opt=repo.findById(id);
		if(opt.isPresent())
		{
			Seat existing=opt.get();
			existing.setBookedStatus(seat.getBookedStatus());
			existing.setRow(seat.getRow());
			existing.setSeatNumber(seat.getSeatNumber());
			existing.setType(seat.getType());
			return repo.save(existing);
		}
		else
		throw new RuntimeException("Seat not found with id:"+id);
	}

	@Override
	public void deleteSeat(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		

	}

}
