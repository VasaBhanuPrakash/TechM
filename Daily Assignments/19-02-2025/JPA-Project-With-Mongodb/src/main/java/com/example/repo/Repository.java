package com.example.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Product;

public interface Repository extends MongoRepository<Product,Integer>{

}
