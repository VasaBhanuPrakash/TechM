package com.example.runner;

import java.util.Optional;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.model.Product;
import com.example.repo.Repository;

@Component
public class Runner implements CommandLineRunner {
	@Autowired
	private Repository repo;
	@Override
	public void run(String ...args) throws Exception{
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1.Insert\n2.Update\n3.Display All\n4.Display Specific row\n5..Delete\n6.Delete All\n7.Exit");
			System.out.print("Enter your choice: ");
			switch(sc.nextInt()) {
			case 1:{
				System.out.print("Enter name of the Employee");
				String name=sc.next();
				System.out.print("Enter salary of the Employee");
				int sal=sc.nextInt();
				repo.save(new Product(name,sal));
				break;
			}
			case 2:{;
				System.out.println("Enter ID of the Employee whose data has to be updated");
				Optional<Product> y=repo.findById(sc.nextInt());
				if(y.isPresent()) {
					Product p = y.get();
					System.out.print("Enter Name of the Employee");
					p.setName(sc.next());
					System.out.print("Enter Salary of the Employee");
					p.setSal(sc.nextInt());
					repo.save(p);
				}
				else {
					System.out.println("No Employee with this ID");
				}
				break;
			}
			case 3:{
				repo.findAll().forEach(System.out::println);
				break;
			}
			case 4:{
				System.out.println("Enter the ID of Emmployee whose data has to be displayed");
				Optional<Product> x = repo.findById(sc.nextInt());
				if(x.isPresent()) {
					System.out.println(x.get());
				}
				else {
					System.out.println("Row is not present");
				}
				break;
			}
			case 5:{
				System.out.println("Enter ID of the Employee whose data has to be deleted");
				int x = sc.nextInt();
				if(repo.findById(x).isPresent()) {
					repo.deleteById(x);
				}
				else {
					System.out.println("Row is not present");
				}
				break;
			}
			case 6:{
				repo.deleteAll();
				break;
			}
			case 7:{
				System.out.println("Thank you");
				return;
			}
			default:{
				System.out.println("Enter the correct choice");
			}
		}
	}
}}