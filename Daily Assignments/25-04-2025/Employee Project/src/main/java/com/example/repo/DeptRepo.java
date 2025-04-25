package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.Department;

public interface DeptRepo extends JpaRepository<Department,Long>{
	Department findByName(String name);
}
