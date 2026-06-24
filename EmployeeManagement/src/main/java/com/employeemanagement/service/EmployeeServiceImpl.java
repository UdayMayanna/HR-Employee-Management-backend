package com.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.dto.DashboardStats;
import com.employeemanagement.entities.Department;
import com.employeemanagement.entities.Employee;
import com.employeemanagement.repositpry.DepartmentRepository;
import com.employeemanagement.repositpry.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private DepartmentRepository deprtRepo;

	@Override
	public Employee addEmployee(Employee employee, int dept_id) {
		Department dept = this.deprtRepo.findById(dept_id);
		employee.setDepartment(dept);
		return this.empRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees(int hr_id) {
		return this.empRepo.findByDepartmentHrHrId(hr_id);
	}

	@Override
	public DashboardStats getDashboardCount(int hr_id) {
		DashboardStats dashStats = new DashboardStats();
		dashStats.setDepartmentCount(this.deprtRepo.countByHrHrId(hr_id));
		dashStats.setManagerCount(this.empRepo.countByDepartmentHrHrIdAndRole(hr_id,"Manager"));
		dashStats.setTeamLeaderCount(this.empRepo.countByDepartmentHrHrIdAndRole(hr_id,"Team Leader"));
		dashStats.setEmployeeCount(this.empRepo.countByDepartmentHrHrId(hr_id));	
		return dashStats;
	}

	@Override
	public void deleteEmployee(int emp_id) {
		 this.empRepo.deleteById(emp_id);
	}

	@Override
	public Employee updateEmployee(Employee employee,int emp_id,int dep_id) {
		Employee currentEmployee = this.empRepo.getById(emp_id);
		currentEmployee.setAddress(employee.getAddress());
		currentEmployee.setDepartment(this.deprtRepo.getById(dep_id));
		currentEmployee.setEmail(employee.getEmail());
		currentEmployee.setFname(employee.getFname());
		currentEmployee.setGender(employee.getGender());
		currentEmployee.setJoiningDate(employee.getJoiningDate());
		currentEmployee.setPhone(employee.getPhone());
		currentEmployee.setRole(employee.getRole());
		
		return this.empRepo.save(currentEmployee);
	}

	@Override
	public Employee getEmployee(int emp_id) {
		return this.empRepo.findByEmpid(emp_id);
	}

	@Override
	public List<Employee> getSerchResults(String query,int hrId) {
       return this.empRepo.findByFnameContainingIgnoreCaseAndDepartmentHrHrId(query,hrId);
	}

	
}
