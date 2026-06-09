package com.employeemanagement.service;

import com.employeemanagement.entities.HR;

public interface HRServices {

	HR addHR(HR hr);
	
	HR loginHr(String email, String password);

	HR updateHr(int id, HR hr);

}
