package com.capg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private int userId;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="contactno")
	private String contactNo;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String firstName,String lastName, String email, String password, String contactNo) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName +", email=" + email
				+ ", password=" + password + ", contactNo=" + contactNo + "]";
	}
	
	
	

}
