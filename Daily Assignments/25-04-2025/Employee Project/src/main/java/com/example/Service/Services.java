package com.example.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.EmpException;
import com.example.Model.Department;
import com.example.Model.Employee;
import com.example.repo.DeptRepo;
import com.example.repo.EmpRepo;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class Services {
	@Autowired
	private EmpRepo repo1;
	@Autowired
	private DeptRepo repo2;
	Map<Integer,String> l=new HashMap<>();
	public Employee login(Integer id,String password) throws EmpException {
		Optional<Employee> e=repo1.findById(id);
		if(password.equals(e.get().getPassword())) {
			if(e.get().getDesignation().equals("Manager")) {
				String otp=String.valueOf(Math.round((Math.random()+1)*100000));
				l.put(id,otp);
				final String senderEmail = "vasabhanuprakash2003@gmail.com";
			    final String senderPassword = "gspl hsxs dodp fbvv";
			    Properties props = new Properties();
			    props.put("mail.smtp.auth", "true");
			    props.put("mail.smtp.starttls.enable", "true");
			    props.put("mail.smtp.host", "smtp.gmail.com");
			    props.put("mail.smtp.port", "587");
			    Session session = Session.getInstance(props, new Authenticator() {
			        protected PasswordAuthentication getPasswordAuthentication() {
			            return new PasswordAuthentication(senderEmail, senderPassword);
			        }
			    });
			    try {
			    	MimeMessage message = new MimeMessage(session);
			        message.setFrom(new InternetAddress(senderEmail));
			        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(e.get().getEmail()));
			        message.setSubject("Your OTP for Login - Indian Banking");
			        message.setText("Hello " + e.get().getEmpid() + ",\n\nYour OTP for login is: " + otp +
			                "\n\nPlease do not share this with anyone.\n\nBest Regards,\nIndian Banking");

			        Transport.send(message);
			        System.out.println("✅ OTP Email Sent Successfully to " + e.get().getEmail());
			    }
			    catch(Exception e1) {
			    	System.err.println("❌ Error Sending Email: " + e1.getMessage());
			    }
			    System.out.println("The OTP "+otp+" is sent to email "+e.get().getEmail());
			}
			return e.get();
		}
		else {
			throw new EmpException("Wrong Employee details");
		}
	}
	public Employee checkOtp(Employee e,String otp) throws EmpException {
		if(l.get(e.getEmpid()).equals(otp)) {
			l.remove(e.getEmpid());
			return e;
		}
		else {
			throw new EmpException("The given OTP is wrong");
		}
	}
	public Employee alogin(Integer id,String pass) throws EmpException {
		Optional<Employee> e=repo1.findById(id);
		if(pass.equals(e.get().getPassword())) {
			if(e.get().getDesignation().equals("Manager")) {
				return e.get();
			}
			else {
				throw new EmpException("Wrong Employee details");
			}
		}
		else {
			throw new EmpException("Wrong Employee details");
		}
		
	}
	public String addEmployee(Employee e) {
		repo1.save(e);
		return "Employee data is saved";
	}
	public List<Employee> getAllEmployee(){
		return repo1.findAll();
	}
	public List<Employee> getEmployeeBydept(String dept) throws EmpException{
		Department d=repo2.findByName(dept);
		if(d!=null) {
			return repo1.findByDept(d);
		}
		else {
			throw new EmpException("There is no department with this name");
		}
	}
	public Optional<Employee> getEmployeeDetails(Integer id) {
		return repo1.findById(id);
	}
	public String updateProject(Integer id,String proj) throws EmpException {
		Optional<Employee> empOpt = repo1.findById(id);
        if (empOpt.isPresent()) {
            Employee emp = empOpt.get();
            List<String> projects = emp.getProjects();
            projects.add(proj);
            emp.setProjects(projects);
            repo1.save(emp);
            return "Project added successfully.";
        } else {
            throw new EmpException("Employee not found");
        }
	}
	public String updateProject(String dept,String proj) throws EmpException {
		Department dept1=repo2.findByName(dept);
		List<Employee> empOpt = repo1.findByDept(dept1);
		if (empOpt.isEmpty()) {
			for(Employee i:empOpt) {
				List<String> project=i.getProjects();
				project.add(proj);
				i.setProjects(project);
				repo1.save(i);
				
			}
			return "Project are added successfully";
        } else {
            throw new EmpException("Employee not found");
        }
	}
	public String updateRating(Integer id,float rating) throws EmpException {
		Optional<Employee> empOpt = repo1.findById(id);
        if (empOpt.isPresent()) {
            Employee emp = empOpt.get();
            emp.setRating(rating);
            repo1.save(emp);
            return "Rating updated successfully.";
        } else {
            throw new EmpException("Employee not found");
        }

	}
	public String updateSal(Integer id,double increment) throws EmpException {
		Optional<Employee> empOpt = repo1.findById(id);
        if (empOpt.isPresent()) {
            Employee emp = empOpt.get();
            emp.setSal(emp.getSal() + increment);
            List<Double> incList = emp.getIncrements();
            incList.add(increment);
            emp.setIncrements(incList);
            repo1.save(emp);
            return "Salary updated successfully.";
        } else {
            throw new EmpException("Employee not found");
        }
	}
	public String setBonus(Integer id,double b) throws EmpException {
		 Optional<Employee> empOpt = repo1.findById(id);
	     if (empOpt.isPresent()) {
	     	 Employee emp = empOpt.get();
	         emp.setBonus(b);
	         repo1.save(emp);
	         return "Bonus updated successfully.";
	     } else {
	    	 throw new EmpException("Employee not found");
	     }
	}
	public String setDesignation(Integer id, String s) throws EmpException {
		Optional<Employee> empOpt = repo1.findById(id);
        if (empOpt.isPresent()) {
            Employee emp = empOpt.get();
            emp.setDesignation(s);
            repo1.save(emp);
            return "Designation updated successfully.";
        } else {
            throw new EmpException("Employee not found");
        }
	}
	public String deleteEmp(Integer id) throws EmpException {
		Optional<Employee> empOpt = repo1.findById(id);
        if (empOpt.isPresent()) {
            repo1.deleteById(id);
            return "Employee deleted successfully.";
        } else {
            throw new EmpException("Employee not found");
        }
	}
}
