package com.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Banking;
import com.example.service.BankingService;

@RestController
@CrossOrigin(origins="http://localhost/4200")
public class BankingController {
	@Autowired
	private BankingService s;
	@PostMapping("/register")
	public String register(@RequestBody Banking b) {
		return s.register(b);
	}
	@GetMapping("/login/{id}/{pass}")
	public Banking login(@PathVariable String id,@PathVariable String pass) {
		return s.login(id, pass);
	}
	@PutMapping("/login/{id}/{pass}/deposit/{val}")
	public String deposit(@PathVariable String id,@PathVariable String pass,@PathVariable double val) {
		return s.deposit(s.login(id, pass), val);
	}
	@PutMapping("/login/{id}/{pass}/withdraw/{val}")
	public String withdraw(@PathVariable String id,@PathVariable String pass,@PathVariable double val) {
		return s.withdraw(s.login(id, pass), val);
	}
	@GetMapping("/login/{id}/{pass}/balance")
	public double balance(@PathVariable String id,@PathVariable String pass) {
		return s.balance(s.login(id, pass));
	}
	@PutMapping("/login/{id}/{pass}/loan/{type}/{val}/{time}")
	public String loan(@PathVariable String id,@PathVariable String pass,@PathVariable String type,@PathVariable float val,@PathVariable int time) {
		return s.loan(s.login(id, pass), type, val, time);
	}
	@GetMapping("/login/{id}/{pass}/details")
	public List<Banking> getAllDetails(@PathVariable String id,@PathVariable String pass) {
		return s.getAllDetails(s.login(id, pass));
	}
	@GetMapping("/login/{id}/{pass}/details/id1")
	public Optional<Banking> getAllDetails(@PathVariable String id,@PathVariable String pass,@PathVariable String id1) {
		return s.getDetails(s.login(id, pass), id1);
	}
}
