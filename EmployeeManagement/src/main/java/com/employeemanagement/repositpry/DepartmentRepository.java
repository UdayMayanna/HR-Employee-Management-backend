package com.employeemanagement.repositpry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagement.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
	
  public List<Department> findByHrHrId(int hr_id);
  
  public Department findById(int dep_id);
  
  public int countByHrHrId(int hr_id);

  public List<Department> findByDepartmentNameContainingIgnoreCaseAndHrHrId(String query,int hr_id);
}
