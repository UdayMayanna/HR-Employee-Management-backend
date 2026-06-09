package com.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.entities.Department;
import com.employeemanagement.service.DepartmentService;

@RestController
@RequestMapping("/department/")
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentSer;
	
	@PostMapping("/{hr_id}/")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department,@PathVariable int hr_id){
		return ResponseEntity.ok(departmentSer.addDepartment(department,hr_id));
	}
	
	@GetMapping("/{hr_id}/")
	public  ResponseEntity<List<Department>> getDepartments(@PathVariable int hr_id){
		List<Department> departments = this.departmentSer.getDepartments(hr_id);
		return ResponseEntity.ok(departments);
	}
	
	@GetMapping("/count/{hr_id}/")
	public ResponseEntity<Integer> getDepartmentCount(@PathVariable int hr_id){
	    return ResponseEntity.ok(this.departmentSer.getCount(hr_id));	
	}
}
