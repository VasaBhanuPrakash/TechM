package com.example.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.Exception.EmpException;
import com.example.Model.Department;
import com.example.Model.Employee;
import com.example.repo.DeptRepo;
import com.example.repo.EmpRepo;

public class TestService {
	@Mock EmpRepo empRepo;
    @Mock DeptRepo deptRepo;

    @InjectMocks
    Services service;

    private Employee manager;
    private Employee regular;
    private Department dept;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        manager = new Employee();
        manager.setEmpid(1);
        manager.setPassword("pass");
        manager.setDesignation("Manager");
        manager.setEmail("mgr@example.com");

        regular = new Employee();
        regular.setEmpid(2);
        regular.setPassword("pass");
        regular.setDesignation("Staff");
        regular.setEmail("staff@example.com");

        dept = new Department();
        dept.setId(10L);
        dept.setName("IT");

        // default stubbing
        when(empRepo.findById(1)).thenReturn(Optional.of(manager));
        when(empRepo.findById(2)).thenReturn(Optional.of(regular));
        when(deptRepo.findByName("IT")).thenReturn(dept);
        when(empRepo.findByDept(dept)).thenReturn(List.of(regular));
    }

    @Test
    void login_AsManager_SendsOtpAndReturns() throws EmpException {
        // first call, no exception
        Employee ret = service.login(1, "pass");
        assertEquals(manager, ret);
        verify(empRepo, times(2)).findById(1);
    }

    @Test
    void login_WrongPassword_Throws() {
        assertThrows(EmpException.class, () -> service.login(1, "wrong"));
    }

    @Test
    void checkOtp_WrongOtp_Throws() throws EmpException {
        service.login(1, "pass");
        assertThrows(EmpException.class, () -> service.checkOtp(empRepo.findById(1).get(), "000000"));
    }
    
    @Test
    void checkOtp_CorrectOtp_ReturnsEmployee() throws EmpException {
        // simulate OTP generated
        service.login(1, "pass");
        // retrieve the generated OTP via reflection
        String otp = service.l.get(1);
        Employee ret = service.checkOtp(empRepo.findById(1).get(), otp);
        assertEquals(manager, ret);
    }

    @Test
    void alogin_OnlyManager_Succeeds() throws EmpException {
        Employee ret = service.alogin(1, "pass");
        assertEquals("Manager", ret.getDesignation());
    }

    @Test
    void alogin_NonManager_Throws() {
        assertThrows(EmpException.class, () -> service.alogin(2, "pass"));
    }

    @Test
    void addEmployee_SavesNew() throws EmpException {
        Employee newEmp = new Employee();
        newEmp.setEmpid(3);
        // we bypass login/OTP here by directly calling addEmployee(E)
        String msg = service.addEmployee(newEmp);
        assertEquals("Employee data is saved", msg);
        verify(empRepo).save(newEmp);
    }

    @Test
    void getEmployeeBydept_HappyPath() throws EmpException {
        List<Employee> list = service.getEmployeeBydept("IT");
        assertEquals(1, list.size());
        assertEquals(regular, list.get(0));
    }

    @Test
    void getEmployeeBydept_NoDept_Throws() {
        when(deptRepo.findByName("HR")).thenReturn(null);
        assertThrows(EmpException.class, () -> service.getEmployeeBydept("HR"));
    }
}