package com.example.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.model.Product;

public interface Repository extends MongoRepository<Product, String> {
    // Custom query methods can be added here
}
