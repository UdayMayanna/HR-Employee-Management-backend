package com.employeemanagement.repositpry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagement.entities.HR;

@Repository
public interface HRRepository extends JpaRepository<HR,Integer> {

	HR findByEmailAndPassword(String email, String password);

}
