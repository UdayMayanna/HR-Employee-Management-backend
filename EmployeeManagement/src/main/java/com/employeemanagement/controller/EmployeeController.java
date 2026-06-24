package com.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.dto.DashboardStats;
import com.employeemanagement.entities.Employee;
import com.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/employee/")
@CrossOrigin("*")
public class EmployeeController {
    
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/{dept_id}/")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee,@PathVariable int dept_id){
		return ResponseEntity.ok(this.employeeService.addEmployee(employee,dept_id));
	}
	
	@GetMapping("/{hr_id}/")
	public ResponseEntity<List<Employee>> getAllEmployees(@PathVariable int hr_id){
		return ResponseEntity.ok(this.employeeService.getAllEmployees(hr_id));
	}
	
	@GetMapping("/dashboard/{hr_id}/")
	public ResponseEntity<DashboardStats> getDashBoardCount(@PathVariable int hr_id){
		return ResponseEntity.ok(this.employeeService.getDashboardCount(hr_id));
	}
	
	@DeleteMapping("/{emp_id}/")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int emp_id){
		this.employeeService.deleteEmployee(emp_id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{emp_id}/{dep_id}/")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,
			@PathVariable int emp_id, @PathVariable int dep_id){
		return ResponseEntity.ok(this.employeeService.updateEmployee(employee,emp_id,dep_id));
	}
	
	@GetMapping("/single/{emp_id}/")
	public ResponseEntity<Employee> getEmployee(@PathVariable int emp_id){
		return ResponseEntity.ok(this.employeeService.getEmployee(emp_id));
	}
	
	@GetMapping("/search/{query}/{hrId}")
	public ResponseEntity<List<Employee>> getSerchResults(@PathVariable String query, @PathVariable int hrId){
		return ResponseEntity.ok(this.employeeService.getSerchResults(query,hrId));
	}
}
