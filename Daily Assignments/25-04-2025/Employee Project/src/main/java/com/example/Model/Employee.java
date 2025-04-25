package com.example.Model;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.example.Gender.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Employee")
@Getter
@Setter
@ToString
public class Employee {
	@Id
	@GeneratedValue
	Integer empid;
	@NotNull(message="Name is required")
	String name;
	@NotNull(message="Email is required")
	@Email(message="Invalid Email Format")
	String email;
	@NotNull(message = "Phone number is required")
	@Size(min = 10, max = 10, message = "Phone number must be 10 digits")
	@Pattern(regexp = "\\d{10}", message = "Phone number must be numeric and 10 digits")
	private String phno;
	LocalDate dob;
	Gender gender;
	boolean married;
	String location;
	String state;
	String nation;
	String password;
	private List<String> skills;
	@ManyToOne
	@JoinColumn(name="Dept_id")
	Department dept;
	@NotNull(message="Date of joining is required")
	LocalDate doj;
	String designation;
	double sal;
	double bonus;
    private List<Double> increments;
	private List<String> projects;
	private float rating;
	@Transient
	public float getExperience() {
        if (doj == null) return 0;
        Period period = Period.between(doj, LocalDate.now());
        return period.getYears() + (period.getMonths() / 12f);
    }
	
}
