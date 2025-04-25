package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.Department;
import com.example.Model.Employee;

public interface EmpRepo extends JpaRepository<Employee,Integer>{
	List<Employee> findByDept(Department dept);
}
