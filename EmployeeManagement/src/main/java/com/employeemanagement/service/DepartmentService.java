package com.employeemanagement.service;

import java.util.List;

import com.employeemanagement.entities.Department;

public interface DepartmentService {

	Department addDepartment(Department department, int hr_id);

	List<Department> getDepartments(int hr_id);

	int getCount(int hr_id);

	String deleteDepartment(int dept_id);

	List<Department> getSearchResult(String query,int hr_id);

	Department getSingleDepartment(int dept_id);

	String updateDepartment(Department departent,int dept_id);

}
