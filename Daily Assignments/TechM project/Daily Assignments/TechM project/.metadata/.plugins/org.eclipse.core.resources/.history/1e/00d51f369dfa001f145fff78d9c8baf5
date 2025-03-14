package com.example.Model;

import com.example.facility.Facility;
import com.example.gender.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Banking")
public class Banking {
	@Id
	@NotNull(message="ID is required")
	String Username;
	@NotNull(message="Email is required")
	@Email(message="Give correct Email ID")
	String email;
	Gender gender;
	@NotNull(message="Location is required")
	String location;
	@NotNull(message="Nationality is required")
	String nationality;
	@NotNull(message="Account no is Required")
	String AccountNo;
	@NotNull(message="CIF No is required")
	@Pattern(regexp="\\d{11}",message="CIF No Should be 11 digits")
	long CifNo;
	@NotNull(message="Branch Code is required")
	@Pattern(regexp="\\d{4,6}",message="Branch code should be between 4-6 digits")
	int BranchCode;
	Facility facility;
	@NotNull(message="Password is required")
	@Size(min=8,message="Password should be greater than 8 characters")
	String Password;
	double balance;
	double loanval;
	double intrest;
	boolean isEmployee;
}
