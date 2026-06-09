package com.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.entities.HR;
import com.employeemanagement.service.HRServices;

@RestController
@RequestMapping("/hr/")
@CrossOrigin("*")
public class HrContoller {
   
	@Autowired
	private HRServices hrServices;
	
	@PostMapping
		ResponseEntity<HR> addHr(@RequestBody HR hr) {
		return ResponseEntity.ok(this.hrServices.addHR(hr));
	}
	
	@GetMapping("/{email}/{password}")
	ResponseEntity<HR> loginHr(@PathVariable String email ,@PathVariable String password) {
		return ResponseEntity.ok(this.hrServices.loginHr(email,password));
	}
	
	@PutMapping("/{id}")
	ResponseEntity<HR> updateHr(@PathVariable int id,@RequestBody HR hr) {
		return ResponseEntity.ok(this.hrServices.updateHr(id,hr));
	}
	
	
}
