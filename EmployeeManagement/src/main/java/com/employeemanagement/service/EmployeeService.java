package com.employeemanagement.service;

import java.util.List;

import com.employeemanagement.dto.DashboardStats;
import com.employeemanagement.entities.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee employee, int dept_id);

	List<Employee> getAllEmployees(int hr_id);

	int getCount(int hr_id);

	DashboardStats getDashboardCount(int hr_id);

	void deleteEmployee(int emp_id);

	Employee updateEmployee(Employee employee,int emp_id);

}
