package com.sjiang2020.model;

public class Customer {

	private int id;
	private String firstName;
	private String lastName;
	private String tel;
	private String email;

	public Customer() {

	}

	public Customer(String firstName, String lastName, String tel, String email) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.tel = tel;
		this.email = email;
	}
	

	public Customer(int id, String firstName, String lastName, String tel, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tel = tel;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", tel=" + tel
				+ ", email=" + email + "]";
	}

}
