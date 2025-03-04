package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.exception.TicketException;
import com.example.model.Ticket;
import com.example.repo.TicketRepo;
@Service
public class TicketService {
	@Autowired
	private TicketRepo repo;
	public Iterable<Ticket> allBookings(){
		return repo.findAll();
	}
	public Optional<Ticket> Booking(String id) throws TicketException{
		if(repo.existsById(id)) {
			return repo.findById(id);
		}
		else {
			throw new TicketException("No ticket is booked with this ID");
		}
	}
	public String addBooking(Ticket t) {
		repo.save(t);
		return "It is saved successfully";
	}
	public String updateBooking(String id,Ticket t) throws TicketException {
		if(repo.existsById(id)) {
			t.setId(id);
			repo.save(t);
			return "It is updated successfully";
		}
		else {
			throw new TicketException("No ticket is booked with this ID");
		}
	}
	public String deleteBooking(String id) throws TicketException{
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "It is deleted successfully";
		}
		else {
			throw new TicketException("No ticket is booked with this ID");
		}
	}
}
