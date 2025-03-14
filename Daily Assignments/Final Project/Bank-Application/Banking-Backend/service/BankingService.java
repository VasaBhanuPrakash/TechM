package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.Banking;
import com.example.exception.BankingException;
import com.example.repo.BankingRepo;

@Service
public class BankingService {
	@Autowired
	private BankingRepo repo;
	public String register(Banking b) {
		repo.save(b);
		return "Account is registered properly";
	}
	public Banking login(String id,String pass) throws BankingException{
		if(repo.existsById(id)) {
			Optional<Banking> x = repo.findById(id);
			if(x.isPresent() && x.get().getPassword().equals(pass)) {
				return x.get();
			}
			else {
				throw new BankingException("Wrong Username or password");
			}
		}
		else {
			throw new BankingException("Wrong Username or password");
		}
	}
	public String deposit(Banking b,double val) {
		b.setBalance(b.getBalance()+val);
		repo.save(b);
		return "Money deposited properly";
	}
	public String withdraw(Banking b,double val) {
		double x=b.getBalance();
		if(x>=val) {
			b.setBalance(b.getBalance()-val);
			repo.save(b);
			return "Money withdrawal is done properly";
		}
		else {
			return "Balance is not sufficient";
		}
	}
	public double balance(Banking b) {
		return b.getBalance();
	}
	public String loan(Banking b,String type,float l,int time) {
		b.setLoanval(b.getLoanval()+l);
		String t = type.toLowerCase();
		if(t.equals("vehicle")) {
			b.setIntrest((l*Math.pow(1.1, time))-l);
		}
		else if(t.equals("home")) {
			b.setIntrest((l*Math.pow(1.08, time))-l);
		}
		else if(t.equals("education")) {
			b.setIntrest((l*Math.pow(1.06, time))-l);
		}
		else {
			b.setIntrest((l*Math.pow(1.05, time))-l);
		}
		repo.save(b);
		return "Loan is provided successfully";
	}
	public List<Banking> getAllDetails(Banking b) {
		if(b.isEmployee()) {
			return repo.findAll();
		}
		else {
			throw new BankingException("Not Allowed");
		}
	}
	public Optional<Banking> getDetails(Banking b,String id) {
		if(b.isEmployee()) {
			if(repo.existsById(id)) {
				return repo.findById(id);
			}
			else {
				throw new BankingException("Wrong Username"); 
			}
		}
		else {
			throw new BankingException("Not Allowed");
		}
	}
}
