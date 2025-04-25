package com.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.EmpException;
import com.example.Model.Employee;
import com.example.Service.Services;

@RestController
public class EmpController {
	@Autowired
	private Services s;
	@GetMapping("/manager/{id}/{pass}")
	public Employee login(@PathVariable Integer id,@PathVariable String pass) throws EmpException {
		if(s.login(id, pass).getDesignation().equals("Manager")) {
			return s.login(id, pass);
		}
		else {
			throw new EmpException("Only Manager can manipulate data");
		}
	}
	@GetMapping("/manager/{id}/{pass}/otp/{otp}")
	public Employee otp(@PathVariable Integer id,@PathVariable String pass,@PathVariable String otp) throws EmpException {
		if(s.login(id, pass).getDesignation().equals("Manager")) {
			return s.checkOtp(s.login(id, pass), otp);
		}
		else {
			throw new EmpException("Only Manager can manipulate data");
		}
	}
	@PostMapping("/manager/{id}/{pass}/otp/{otp}/emp")
	public String addEmp(@PathVariable Integer id,@PathVariable String pass,@RequestBody Employee e) throws EmpException {
		if(s.alogin(id, pass).getDesignation().equals("Manager")) {
			return s.addEmployee(e);
		}
		else {
			throw new EmpException("Only Manager can manipulate data");
		}
	}
	@GetMapping("/manager/{id}/{pass}/otp/{otp}/emp")
	public List<Employee> getAllEmp(@PathVariable Integer id,@PathVariable String pass) throws EmpException{
		if(s.alogin(id, pass).getDesignation().equals("Manager")) {
			return s.getAllEmployee();
		}
		else {
			throw new EmpException("Only Manager can manipulate data");
		}
	}
	@GetMapping("/manager/{id}/{pass}/dept/{dept}")
	public List<Employee> getEmpByDept(@PathVariable Integer id,@PathVariable String pass,@PathVariable String dept) throws EmpException{
		if(s.alogin(id, pass).getDesignation().equals("Manager")) {
			return s.getEmployeeBydept(dept);
		}
		else {
			throw new EmpException("Only Manager can manipulate data");
		}
	}
	@GetMapping("/manager/{id}/{pass}/emp/{id1}")
	public Optional<Employee> getEmpDetails(@PathVariable Integer id,@PathVariable String pass,@PathVariable Integer id1) throws EmpException {
		if(s.alogin(id, pass).getDesignation().equals("Manager")) {
			return s.getEmployeeDetails(id1);
		}
		else {
			throw new EmpException("Only Manager can manipulate data");
		}
	}
	@PutMapping("/manager/{id}/{pass}/emp/{id1}/proj/{p}")
	public String updateProj(@PathVariable Integer id,@PathVariable String pass,@PathVariable Integer id1,@PathVariable String p) throws EmpException {
		if(s.alogin(id, pass).getDesignation().equals("Manager")) {
			return s.updateProject(id1, p);
		}
		else {
			throw new EmpException("Only Manager can manipulate data");
		}
	}
	@PutMapping("/dept/{dept}/proj/{p}")
	public String updateDeptProj(@PathVariable Integer id,@PathVariable String pass,@PathVariable String dept, @PathVariable String p) throws EmpException {
		if(s.alogin(id, pass).getDesignation().equals("Manager")) {
			return s.updateProject(dept, p);
		}
		else {
			throw new EmpException("Only Manager can manipulate data");
		}
    }
	@PutMapping("/manager/{id}/{pass}/emp/{id1}/rating/{r}")
    public String updateRating(@PathVariable Integer id,@PathVariable String pass,@PathVariable Integer id1, @PathVariable float r) throws EmpException {
		if(s.alogin(id, pass).getDesignation().equals("Manager")) {
			return s.updateRating(id1, r);
		}
		else {
			throw new EmpException("Only Manager can manipulate data");
		}
    }
	@PutMapping("/manager/{id}/{pass}/emp/{id1}/increment/{inc}")
    public String updateSalary(@PathVariable Integer id,@PathVariable String pass,@PathVariable Integer id1, @PathVariable double inc) throws EmpException {
		if(s.alogin(id, pass).getDesignation().equals("Manager")) {
			return s.updateSal(id1, inc);
		}
		else {
			throw new EmpException("Only Manager can manipulate data");
		}
    }
	@PutMapping("/manager/{id}/{pass}/emp/{id1}/bonus/{b}")
    public String setBonus(@PathVariable Integer id,@PathVariable String pass,@PathVariable Integer id1, @PathVariable double b) throws EmpException {
		if(s.alogin(id, pass).getDesignation().equals("Manager")) {
			return s.setBonus(id1, b);
		}
		else {
			throw new EmpException("Only Manager can manipulate data");
		}
    }
	@PutMapping("/manager/{id}/{pass}/emp/{id1}/designation/{d}")
    public String setDesignation(@PathVariable Integer id,@PathVariable String pass,@PathVariable Integer id1, @PathVariable String d) throws EmpException {
		if(s.alogin(id, pass).getDesignation().equals("Manager")) {
			return s.setDesignation(id1, d);
		}
		else {
			throw new EmpException("Only Manager can manipulate data");
		}
    }
	@DeleteMapping("/manager/{id}/{pass}/emp/{id1}")
    public String deleteEmployee(@PathVariable Integer id,@PathVariable String pass,@PathVariable Integer id1) throws EmpException {
		if(s.alogin(id, pass).getDesignation().equals("Manager")) {
			return s.deleteEmp(id1);
		}
		else {
			throw new EmpException("Only Manager can manipulate data");
		}
    }
}
