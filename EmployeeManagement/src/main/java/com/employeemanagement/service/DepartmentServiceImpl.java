package com.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.entities.Department;
import com.employeemanagement.entities.HR;
import com.employeemanagement.repositpry.DepartmentRepository;
import com.employeemanagement.repositpry.EmployeeRepository;
import com.employeemanagement.repositpry.HRRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
 
	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Autowired
	private HRRepository hrRepo;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public Department addDepartment(Department department, int hr_id) {
		HR hr = this.hrRepo.findById(hr_id).orElse(null);
		department.setHr(hr);
		return departmentRepo.save(department);
	}

	@Override
	public List<Department> getDepartments(int hr_id) {
		List<Department> departments = this.departmentRepo.findByHrHrId(hr_id);
		return departments;
	}

	@Override
	public int getCount(int hr_id) {
		return this.departmentRepo.countByHrHrId(hr_id);
	}

	@Override
	public String deleteDepartment(int dept_id) {
		if(this.empRepo.existsByDepartmentId(dept_id)) {
			return "Department can not deleted becuase Employee asigned to it.";
		}
		this.departmentRepo.deleteById(dept_id);
		return "Department deleted successfully.";
	}

	@Override
	public List<Department> getSearchResult(String query,int hr_id) {
		return this.departmentRepo.findByDepartmentNameContainingIgnoreCaseAndHrHrId(query,hr_id);
	}

	@Override
	public Department getSingleDepartment(int dept_id) {
      return this.departmentRepo.findById(dept_id);
	}

	@Override
	public String updateDepartment(Department departent,int dept_id) {
		Department currentDepartment = departmentRepo.findById(dept_id);
		currentDepartment.setDepartmentName(departent.getDepartmentName());
		this.departmentRepo.save(currentDepartment);
		
		return "Department updated successfully";
	}

}
