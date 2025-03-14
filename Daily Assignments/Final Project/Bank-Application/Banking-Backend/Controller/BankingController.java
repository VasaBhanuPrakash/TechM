package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.Banking;
import com.example.Service.BankingService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BankingController {
    
    @Autowired
    private BankingService s;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Banking b) {
        return new ResponseEntity<>(s.register(b), HttpStatus.CREATED);
    }

    @GetMapping("/login/{id}/{pass}")
    public ResponseEntity<Banking> login(@PathVariable String id, @PathVariable String pass) {
        return ResponseEntity.ok(s.login(id, pass));
    }
    
    @GetMapping("/login/{id}/{pass}/otp/{otp}")
    public ResponseEntity<Banking> checkOtp(@PathVariable String id, @PathVariable String pass,@PathVariable String otp){
    	return ResponseEntity.ok(s.checkOtp(s.login(id, pass), otp));
    }

    @GetMapping("/elogin/{id}/{pass}")
    public ResponseEntity<Banking> elogin(@PathVariable String id, @PathVariable String pass) {
        return ResponseEntity.ok(s.elogin(id, pass));
    }
    
    @GetMapping("/elogin/{id}/{pass}/otp/{otp}")
    public ResponseEntity<Banking> checkEmpOtp(@PathVariable String id, @PathVariable String pass,@PathVariable String otp){
    	return ResponseEntity.ok(s.checkOtp(s.elogin(id, pass), otp));
    }

    @GetMapping("/alogin/{id}/{pass}")
    public ResponseEntity<Banking> alogin(@PathVariable String id, @PathVariable String pass) {
        return ResponseEntity.ok(s.alogin(id, pass));
    }
    
    @GetMapping("/alogin/{id}/{pass}/otp/{otp}")
    public ResponseEntity<Banking> checAdmkOtp(@PathVariable String id, @PathVariable String pass,@PathVariable String otp){
    	return ResponseEntity.ok(s.checkOtp(s.alogin(id, pass), otp));
    }

    @PutMapping("/login/{id}/{pass}/deposit/{val}")
    public ResponseEntity<String> deposit(@PathVariable String id, @PathVariable String pass, @PathVariable double val) {
        return ResponseEntity.ok(s.deposit(s.login(id, pass), val));
    }

    @PutMapping("/login/{id}/{pass}/withdraw/{val}")
    public ResponseEntity<String> withdraw(@PathVariable String id, @PathVariable String pass, @PathVariable double val) {
        return ResponseEntity.ok(s.withdraw(s.login(id, pass), val));
    }

    @GetMapping("/login/{id}/{pass}/balance")
    public ResponseEntity<Double> balance(@PathVariable String id, @PathVariable String pass) {
        return ResponseEntity.ok(s.balance(s.login(id, pass)));
    }

    @PutMapping("/login/{id}/{pass}/loan/{type}/{val}/{time}")
    public ResponseEntity<String> loan(@PathVariable String id, @PathVariable String pass, @PathVariable String type, @PathVariable float val, @PathVariable int time) {
        return ResponseEntity.ok(s.loan(s.login(id, pass), type, val, time));
    }

    @GetMapping("/elogin/{id}/{pass}/details")
    public ResponseEntity<List<Banking>> getAllDetails(@PathVariable String id, @PathVariable String pass) {
        return ResponseEntity.ok(s.getAllDetails(s.login(id, pass)));
    }

    @GetMapping("/elogin/{id}/{pass}/details/{id1}")
    public ResponseEntity<Optional<Banking>> getDetails(@PathVariable String id, @PathVariable String pass, @PathVariable String id1) {
        return ResponseEntity.ok(s.getDetails(s.login(id, pass), id1));
    }

    @GetMapping("/login/{id}/{pass}/details")
    public ResponseEntity<Banking> getMyDetails(@PathVariable String id, @PathVariable String pass) {
        return ResponseEntity.ok(s.login(id, pass));
    }

    @PutMapping("/login/{id}/{pass}/trans/{id1}/{val}")
    public ResponseEntity<String> transaction(@PathVariable String id, @PathVariable String pass, @PathVariable String id1, @PathVariable double val) {
        return ResponseEntity.ok(s.transaction(s.login(id, pass), id1, val));
    }

    @PutMapping("/login/{id}/{pass}/feedback/{message}")
    public ResponseEntity<String> feedback(@PathVariable String id, @PathVariable String pass, @PathVariable String message) {
        return ResponseEntity.ok(s.addFeed(s.login(id, pass), message));
    }

    @GetMapping("/elogin/{id}/{pass}/getfeedback")
    public ResponseEntity<List<String>> getFeedback(@PathVariable String id, @PathVariable String pass) {
        return ResponseEntity.ok(s.getAllFeedback(s.login(id, pass)));
    }

    @GetMapping("/login/{id}/{pass}/trans")
    public ResponseEntity<List<Double>> getTransaction(@PathVariable String id, @PathVariable String pass) {
        return ResponseEntity.ok(s.getTrans(s.login(id, pass)));
    }
    
    @GetMapping("/elogin/{id}/{pass}/trans")
    public ResponseEntity<List<List<Double>>> getAllTransaction(@PathVariable String id, @PathVariable String pass) {
        return ResponseEntity.ok(s.getAllTrans(s.elogin(id, pass)));
    }
    
    @GetMapping("/elogin/{id}/{pass}/trans/{id1}")
    public ResponseEntity<List<Double>> getTransaction(@PathVariable String id, @PathVariable String pass, @PathVariable String id1) {
        return ResponseEntity.ok(s.getTrans(s.login(id, pass), id1));
    }

    @PutMapping("/alogin/{id}/{pass}/emp/{id1}")
    public ResponseEntity<String> makeEmp(@PathVariable String id, @PathVariable String pass, @PathVariable String id1) {
        return ResponseEntity.ok(s.makeEmp(s.alogin(id, pass), id1));
    }

    @GetMapping("/elogin/{id}/{pass}/approve")
    public ResponseEntity<List<String>> showApproval(@PathVariable String id, @PathVariable String pass) {
        return ResponseEntity.ok(s.showApprovals(s.elogin(id, pass)));
    }

    @GetMapping("/alogin/{id}/{pass}/approve")
    public ResponseEntity<List<String>> showAdminApproval(@PathVariable String id, @PathVariable String pass) {
        return ResponseEntity.ok(s.showAdminApprovals(s.alogin(id, pass)));
    }

    @PutMapping("/alogin/{id}/{pass}/approve/trans/{id1}/{b}")
    public ResponseEntity<String> approveATrans(@PathVariable String id, @PathVariable String pass, @PathVariable String id1, @PathVariable boolean b) {
        return ResponseEntity.ok(s.approveAdminTrans(s.alogin(id, pass), id1, b));
    }

    @PutMapping("/alogin/{id}/{pass}/approve/loan/{id1}/{b}")
    public ResponseEntity<String> approveAdminLoan(@PathVariable String id, @PathVariable String pass, @PathVariable String id1, @PathVariable boolean b) {
        return ResponseEntity.ok(s.approveAdminLoan(s.alogin(id, pass), id1, b));
    }

    @PutMapping("/elogin/{id}/{pass}/trans/approve/{id1}/{b}")
    public ResponseEntity<String> approveTrans(@PathVariable String id, @PathVariable String pass, @PathVariable String id1, @PathVariable boolean b) {
        return ResponseEntity.ok(s.approveTrans(s.elogin(id, pass), id1, b));
    }

    @PutMapping("/elogin/{id}/{pass}/loan/approve/{id1}/{b}")
    public ResponseEntity<String> approveLoan(@PathVariable String id, @PathVariable String pass, @PathVariable String id1, @PathVariable boolean b) {
        return ResponseEntity.ok(s.approveLoan(s.elogin(id, pass), id1, b));
    }

    @DeleteMapping("/alogin/{id}/{pass}/delete/{id1}")
    public ResponseEntity<String> delete(@PathVariable String id, @PathVariable String pass, @PathVariable String id1) {
        return ResponseEntity.ok(s.deleteData(s.alogin(id, pass), id1));
    }

    @PutMapping("/alogin/{id}/{pass}/freeze/{id1}")
    public ResponseEntity<String> freeze(@PathVariable String id, @PathVariable String pass, @PathVariable String id1) {
        return ResponseEntity.ok(s.freeze(s.alogin(id, pass), id1));
    }
}
