package com.employeemanagement.service;

import java.util.List;

import com.employeemanagement.entities.Department;

public interface DepartmentService {

	Department addDepartment(Department department, int hr_id);

	List<Department> getDepartments(int hr_id);

	int getCount(int hr_id);

}
