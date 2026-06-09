package com.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.entities.HR;
import com.employeemanagement.repositpry.HRRepository;

@Service
public class HRServiceImpl implements HRServices {

	@Autowired
	private HRRepository hrRepository;
	
	@Override
	public HR addHR(HR hr) {
		return hrRepository.save(hr);
	}

	@Override
	public HR loginHr(String email, String password) {
		return hrRepository.findByEmailAndPassword(email,password);
	}

	@Override
	public HR updateHr(int id, HR hr) {
		
		HR currentHr = this.hrRepository.getById(id);
		
		currentHr.setFname(hr.getFname());
		currentHr.setEmail(hr.getEmail());
		currentHr.setPhone(hr.getPhone());
		currentHr.setPassword(hr.getPassword());
		currentHr.setGender(hr.getGender());
		
		return this.hrRepository.save(currentHr);
	} 

}
