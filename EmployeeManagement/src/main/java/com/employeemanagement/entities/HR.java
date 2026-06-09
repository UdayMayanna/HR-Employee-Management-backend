package com.employeemanagement.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class HR {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hrId;
	
	private String fname;
	private String email;
	private String phone;
	private String password;
	private String gender;
	
	@OneToMany(mappedBy = "hr")
	@JsonManagedReference
    private List<Department> departments;

	public HR() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HR(Integer hrId, String fname, String email, String phone, String password, String gender,
			List<Department> departments) {
		super();
		this.hrId = hrId;
		this.fname = fname;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.gender = gender;
		this.departments = departments;
	}

	public Integer getHrId() {
		return hrId;
	}

	public void setHrId(Integer hrId) {
		this.hrId = hrId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "HR [hrId=" + hrId + ", fname=" + fname + ", email=" + email + ", phone=" + phone + ", password="
				+ password + ", gender=" + gender + ", departments=" + departments + "]";
	}
	
}
