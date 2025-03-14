package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.Banking;

public interface BankingRepo extends JpaRepository<Banking,String>{

}
