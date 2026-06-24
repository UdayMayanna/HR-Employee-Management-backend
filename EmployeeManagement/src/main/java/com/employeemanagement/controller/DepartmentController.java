package com.employeemanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 	
	@DeleteMapping("/{dept_id}/")
	public ResponseEntity<Map<String,String>> deleteDepartmentById(@PathVariable int dept_id){
		
		String msg = this.departmentSer.deleteDepartment(dept_id);
		
		Map<String,String> response = new HashMap<>();	
		response.put("message", msg);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/search/{query}/{hr_id}")
	public ResponseEntity<List<Department>> searchDepartment(@PathVariable String query,@PathVariable int hr_id){
		return ResponseEntity.ok(this.departmentSer.getSearchResult(query,hr_id));
	}
	
	@GetMapping("/single/{dept_id}/")
	public ResponseEntity<Department> getDepartment(@PathVariable int dept_id){
		return ResponseEntity.ok(this.departmentSer.getSingleDepartment(dept_id));
	}
	
	@PutMapping("/{dept_id}/")
	public ResponseEntity<Map<String,String>> updateDepartment(@RequestBody Department departent,@PathVariable int dept_id){
		String msg = this.departmentSer.updateDepartment(departent,dept_id);
		Map<String,String> response = new HashMap<>();
		response.put("message", msg);
		return ResponseEntity.ok(response);
	}
}
