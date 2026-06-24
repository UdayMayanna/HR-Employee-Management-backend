package com.employeemanagement.entities;

import java.time.LocalDate;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empid;
	
	private String fname;
	private String email;
	private String phone;
	private String gender;
	private String role;
	private LocalDate joiningDate;
	private String address;
	
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department department;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer empid, String fname, String email, String phone, String gender, String role,
			LocalDate joiningDate, String address, Department department) {
		super();
		this.empid = empid;
		this.fname = fname;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.role = role;
		this.joiningDate = joiningDate;
		this.address = address;
		this.department = department;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", fname=" + fname + ", email=" + email + ", phone=" + phone + ", gender="
				+ gender + ", role=" + role + ", joiningDate=" + joiningDate + ", address=" + address + ", department="
				+ department + "]";
	}
	
}
