package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Product;

public interface Repository extends JpaRepository<Product,Integer>{
	interface myView{
		String getId();
		String getName();
		int getSal();
	}
	List<myView>findByName(String name);
}
