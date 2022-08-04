package com.sjiang2020.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="AUTHORITIES")
@Entity
public class Authorities {
	
	@Id
	@Column(name="AUTHORITY")
	private String authority;
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private User user;
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

	
}
