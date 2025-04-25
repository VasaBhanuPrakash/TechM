package com.example.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="department")
@Getter
@Setter
@ToString
public class Department {
	@Id
	@GeneratedValue
	Long id;
	String name;
	@OneToMany(mappedBy="dept")
	List<Employee> emp;
}
