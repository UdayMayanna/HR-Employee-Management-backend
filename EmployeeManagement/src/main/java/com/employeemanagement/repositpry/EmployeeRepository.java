package com.employeemanagement.repositpry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanagement.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  public List<Employee> findByDepartmentHrHrId(int hr_id);
  
  public int countByDepartmentHrHrId(int hr_id);
  
  public int countByDepartmentHrHrIdAndRole(int hr_id,String role);
  
  public Employee findByEmpid(int emp_id);
  
  public boolean existsByDepartmentId(int dept_id);
  
  public List<Employee> findByFnameContainingIgnoreCaseAndDepartmentHrHrId(String fname,int hrId);
  }
