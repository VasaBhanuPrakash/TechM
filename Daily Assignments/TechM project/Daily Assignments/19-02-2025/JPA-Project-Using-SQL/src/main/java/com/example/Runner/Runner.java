package com.example.Runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.model.Product;
import com.example.repo.Repository;

@Component
public class Runner implements CommandLineRunner {
	private final static Logger LOGGER = LoggerFactory.getLogger(Runner.class);
	@Autowired
	private Repository repo;
	@Override
	public void run(String ...args) throws Exception{
		Product product = new Product("Ramesh", 65000);
		repo.save(product);
		LOGGER.info("Product saved: {}", product);
	}
}
