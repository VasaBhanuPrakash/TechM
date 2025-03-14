package com.example.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Banking;
import com.example.exception.BankingException;
import com.example.facility.Facility;
import com.example.repo.BankingRepo;

@Service
public class BankingService {
	@Autowired
	private BankingRepo repo;
	Map<String,String> l=new HashMap<>();
	public String register(Banking b) {
	    try {
	        repo.save(b);
	        return "Account is registered properly.";
	    } catch (Exception e) {
	        throw new BankingException("Error while registering the account: " + e.getMessage());
	    }
	}
	public Banking login(String id,String pass) throws BankingException{
		if(repo.existsById(id)) {
			Optional<Banking> x = repo.findById(id);
			if(x.isPresent() && x.get().getPassword().equals(pass)) {
				String otp=String.valueOf(Math.round((Math.random()+1)*100000));
				l.put(id,otp);
				System.out.println("The OTP "+otp+" is sent to email "+x.get().getEmail());
				return x.get();
			}
			else {
				throw new BankingException("Wrong Username or password");
			}
		}
		else {
			throw new BankingException("Wrong Username or password");
		}
	}
	public Banking elogin(String id,String pass) throws BankingException{
		if(repo.existsById(id)) {
			Optional<Banking> x = repo.findById(id);
			if(x.isPresent() && x.get().getPassword().equals(pass)) {
				if(x.get().isEmployee()) {
					String otp=String.valueOf(Math.round((Math.random()+1)*100000));
					l.put(id,otp);
					System.out.println("The OTP "+otp+" is sent to email "+x.get().getEmail());
					return x.get();
				}
				else {
					throw new BankingException("Wrong Username or password");
				}
			}
			else {
				throw new BankingException("Wrong Username or password");
			}
		}
		else {
			throw new BankingException("Wrong Username or password");
		}
	}
	public Banking alogin(String id,String pass) throws BankingException{
		if(repo.existsById(id)) {
			Optional<Banking> x = repo.findById(id);
			if(x.isPresent() && x.get().getPassword().equals(pass)) {
				if(x.get().isAdmin()) {
					String otp=String.valueOf(Math.round((Math.random()+1)*100000));
					l.put(id,otp);
					System.out.println("The OTP "+otp+" is sent to email "+x.get().getEmail());
					return x.get();
				}
				else {
					throw new BankingException("Wrong Username or password");
				}
			}
			else {
				throw new BankingException("Wrong Username or password");
			}
		}
		else {
			throw new BankingException("Wrong Username or password");
		}
	}
	public Banking checkOtp(Banking b,String otp) {
		if(l.get(b.getUsername()).equals(otp)) {
			l.remove(b.getUsername());
			return b;
		}
		else {
			throw new BankingException("The given OTP is wrong");
		}
	}
	public String deposit(Banking b, double val) {
	    if (b.getTransaction() == null) {  
	        b.setTransaction(new ArrayList<>());
	    }
	    
	    if (b.getTransPer() == null) {  // Fix: Ensure TransPer is initialized
	        b.setTransPer(new ArrayList<>());
	    }
	    
	    if (val > 50000) {
	        if (b.isAllowTrans()) {
	            b.setAllowTrans(false);
	            if (b.getFacility().equals(Facility.valueOf("Full"))) {
	                System.out.println(b.getBalance());
	                b.setBalance(b.getBalance() + val);
	                System.out.println(b.getBalance());
	                b.setFacility(Facility.valueOf("Full"));
	                b.getTransaction().add(val);
	                b.setAllowTrans(false);
	                b.setNeededTransaction(false);
	                repo.save(b);
	                login(b.getUsername(), b.getPassword());
	                return "Money deposited properly";
	            } else {
	                return "Money can't be deposited";
	            }
	        } else {
	            b.setNeededTransaction(true);
	            b.getTransPer().add(val);
	            repo.save(b);
	            return "Wait for Manager to Approve";
	        }
	    } else {
	        if (b.getFacility().equals(Facility.valueOf("view"))) {
	            return "Money can't be deposited";
	        } else {
	            b.setBalance(b.getBalance() + val);
	            b.getTransaction().add(val);
	            repo.save(b);
	            return "Money deposited properly";
	        }
	    }
	}
	public String withdraw(Banking b,double val) {
		if (b.getTransaction() == null) {  
	        b.setTransaction(new ArrayList<>());
	    }
		if(val>50000) {
			if(b.isAllowTrans()) {
				b.setAllowTrans(false);
				if(b.getFacility().equals(Facility.valueOf("Full"))) {
					System.out.println(b.getBalance());
					b.setBalance(b.getBalance()-val);
					System.out.println(b.getBalance());
					b.getTransaction().add(-val);
					b.setAllowTrans(false);
					b.setNeededTransaction(false);
					repo.save(b);
					return "Money withdrawl is done properly";
				}
				else{
					return "Money withdrawl can't be done";
				}
			}
			else {
				b.setNeededTransaction(true);
				b.getTransPer().add(-val);
				repo.save(b);
				return "Wait for Manager to Approve";
			}
		}
		else {
			if(b.getFacility().equals(Facility.valueOf("view"))) {
				return "Money withdrawl can't be done";
			}
			else{
				b.setBalance(b.getBalance()-val);
				b.getTransaction().add(-val);
				repo.save(b);
				return "Money withdrawl is done properly";
			}
		}
	}
	public double balance(Banking b) {
		return b.getBalance();
	}
	public String transaction(Banking b,String id,double val) throws BankingException{
		if (b.getTransaction() == null) {
	        b.setTransaction(new ArrayList<>());
	    }
		if(withdraw(b,val).equals("Money withdrawl is done properly")) {
			Banking x = repo.findById(id).orElseThrow(()->new BankingException("User not found with the User name "+id));
			System.out.println("Balance of "+b.getUsername()+" is: "+b.getBalance());
			if (x.getTransaction() == null) {
	            x.setTransaction(new ArrayList<>());
	        }
			if(deposit(x,val).equals("Money deposited properly")) {
				System.out.println("Balance of "+id+" is: "+x.getBalance());
				return "Transaction is made properly";
			}
			else {
				deposit(b,val);
				return "Transaction failed";
			}
		}
		else {
			return "transaction failed";
		}
	}
	public String loan(Banking b,String type,float l,int time) {
		b.setLoanval(b.getLoanval()+l);
		String t = type.toLowerCase();
		if(t.equals("vehicle")) {
			b.setIntrest((l*Math.pow(1.1, time))-l);
		}
		else if(t.equals("home")) {
			b.setIntrest((l*Math.pow(1.08, time))-l);
		}
		else if(t.equals("education")) {
			b.setIntrest((l*Math.pow(1.06, time))-l);
		}
		else {
			b.setIntrest((l*Math.pow(1.05, time))-l);
		}
		if(b.isAllowLoan()) {
			b.setBalance(b.getBalance()+l);
			b.setAllowLoan(false);
			repo.save(b);
			return "Loan is provided successfully";
		}
		else {
			b.setNeedLoan(true);
			b.setNeededLoan(l);
			b.setLoanTime(time);
			b.setLoanType(type);
			repo.save(b);
			return "Loan is to be approved";
		}
	}
	public List<Double> getTrans(Banking b){
		return b.getTransaction();
	}
	public List<Double> getTrans(Banking b,String id) {
		if(repo.existsById(id)) {
			return b.getTransaction();
		}
		else {
			throw new BankingException("There is no user with UserName"+id);
		}
	}
	public List<List<Double>> getAllTrans(Banking b){
		List<List<Double>> l=new ArrayList<>();
		for(Banking i:repo.findAll()) {
			l.add(i.getTransaction());
		}
		return l;
	}
	public List<Banking> getAllDetails(Banking b) {
		return repo.findAll();
	}
	public Optional<Banking> getDetails(Banking b,String id) {
		if(repo.existsById(id)) {
			return repo.findById(id);
		}
		else {
			throw new BankingException("Wrong Username"); 
		}
	}
	public Banking getMyDetails(Banking b){
		return b;
	}
	public String addFeed(Banking b, String message) {
		b.setMessage(message);
		repo.save(b);
		return "Feedback is given successfully";
	}
	public List<String> getAllFeedback(Banking b){
		return repo.findAll().stream()
				.map(Banking::getMessage)
	            .filter(msg -> msg != null && !msg.isEmpty())
	            .collect(Collectors.toList());
	}
	public String makeEmp(Banking b,String id) {
		if(b.isAdmin()) {
			Banking x = repo.getById(id);
			x.setEmployee(true);
			repo.save(x);
			return "Entry of a new employee is done with User name "+id;
		}
		else {
			return "It is restricted to Admin";
		}
	}
	public String deleteData(Banking b,String id) throws BankingException {
		if(b.isAdmin()) {
			if(repo.existsById(id)) {
				repo.deleteById(id);
				return "User name with id "+id+" is deleted";
			}
			else {
				throw new BankingException("There is no user with user name"+id);
			}
		}
		else {
			throw new BankingException("It is restricted");
		}
	}
	public String freeze(Banking b,String id) {
		if(repo.existsById(id)) {
			Banking x = repo.getById(id);
			x.setFacility(Facility.valueOf("view"));
			x.setAllowLoan(false);
			x.setAllowTrans(false);
			x.setNeededTransaction(false);
			x.setNeedLoan(false);
			x.setFreeze(true);
			repo.save(x);
			return "The account of user with "+id+" is freezed";
		}
		else {
			throw new BankingException("There is no user with user name"+id);
		}
	}
	public String approveAdminTrans(Banking b, String id,boolean a) {
		Banking x=repo.getById(id);
		x.setAllowTrans(a);
		if(x.isTchecked()) {
			if(a) {
				double val=x.getTransPer().remove(x.getTransPer().size()-1);;
				System.out.println(val);
				if(val>0) {
					System.out.println("Deposit");
					return deposit(x,val);
				}
				else {
					System.out.println("Withdraw");
					return withdraw(x,Math.abs(val));
				}
			}
			else {
				return "Transaction is not approved";
			}
		}
		else {
			return "There is no pending transactions";
		}
	}
	public String approveTrans(Banking b,String id,boolean a) {
		Banking x=repo.getById(id);
		x.setAllowTrans(a);
		if(a) {
			x.setTchecked(a);
			repo.save(x);
			return "Waiting for Admin to approve";
		}
		else {
			x.getTransPer().remove(x.getTransPer().size()-1);
			return "Transaction failed";
		}
	}
	public String approveAdminLoan(Banking b,String id,boolean a) {
		Banking x=repo.getById(id);
		x.setAllowTrans(a);
		if(a) {
			return loan(x,x.getLoanType(),x.getNeededLoan(),x.getLoanTime());
		}
		else {
			return "Loan is not approved";
		}
		
	}
	public String approveLoan(Banking b,String id,boolean a) {
		Banking x=repo.getById(id);
		x.setAllowLoan(a);
		if(a) {
			x.setLchecked(a);
			repo.save(x);
			return "Waiting for admin to approve";
		}
		else {
			x.setAllowLoan(false);
			x.setLoanval(0);
			x.setLoanType("");
			x.setLoanTime(0);
			x.setNeededLoan(0);
			x.setNeedLoan(false);
			repo.save(x);
			return "Loan is not approved";
		}
	}
	public List<String> showApprovals(Banking b) {
	    if (!b.isEmployee()) {
	        throw new BankingException("Only employees can view approvals.");
	    }

	    List<Banking> pendingApprovals = repo.findAll().stream()
	        .filter(user -> user.isNeededTransaction() || user.isNeedLoan())
	        .collect(Collectors.toList());

	    if (pendingApprovals.isEmpty()) {
	        return List.of("No pending approvals.");
	    }

	    return pendingApprovals.stream()
	        .map(user -> {
	            StringBuilder approvalInfo = new StringBuilder("User: " + user.getUsername());
	            if (user.isNeededTransaction() && !user.getTransaction().isEmpty()) {
	                double lastTransaction = user.getTransaction().get(user.getTransaction().size() - 1);
	                String transactionType = lastTransaction > 0 ? "Deposit" : "Withdraw";
	                approvalInfo.append(" | Pending Transaction: ")
	                        .append(transactionType)
	                        .append(" ₹")
	                        .append(Math.abs(lastTransaction));
	            }
	            
	            if (user.isNeedLoan()) {
	                approvalInfo.append(" | Pending Loan Amount: ₹").append(user.getNeededLoan()).append(user.getLoanTime());
	            }
	            
	            return approvalInfo.toString();
	        })
	        .collect(Collectors.toList());
	}
	public List<String> showAdminApprovals(Banking b) {
	    if (!b.isEmployee()) {
	        throw new BankingException("Only employees can view approvals.");
	    }

	    List<Banking> pendingApprovals = repo.findAll().stream()
	        .filter(user -> user.getTransPer() != null && !user.getTransPer().isEmpty())
	        .collect(Collectors.toList());

	    if (pendingApprovals.isEmpty()) {
	        return List.of("No pending approvals.");
	    }

	    return pendingApprovals.stream()
	        .map(user -> {
	            StringBuilder approvalInfo = new StringBuilder("User: " + user.getUsername());

	            if (user.isNeededTransaction() && user.getTransPer() != null && !user.getTransPer().isEmpty()) {
	                double lastTransaction = user.getTransPer().get(user.getTransPer().size() - 1);
	                String transactionType = lastTransaction > 0 ? "Deposit" : "Withdraw";
	                approvalInfo.append(" | Pending Transaction: ")
	                    .append(transactionType)
	                    .append(" ₹")
	                    .append(Math.abs(lastTransaction));
	            }
	            if (user.isLchecked()) {
	                approvalInfo.append(" | Pending Loan Amount: ₹").
	                append(user.getNeededLoan());
	            }
	            return approvalInfo.toString();
	        })
	        .collect(Collectors.toList());
	    
	}
}
