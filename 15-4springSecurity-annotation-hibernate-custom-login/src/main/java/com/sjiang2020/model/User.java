package com.sjiang2020.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name ="USER")
@Entity
public class User {

	 
	@Id
	@Column(name="USERNAME")
	private String name;
	@Column(name="PASSWORD", nullable=false)
	private String password;
	@Column(name="ENABLED", nullable=false)
	private boolean enabled;

	@OneToMany(cascade= CascadeType.ALL, mappedBy="user")
	private Set<Authorities> authorities =new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}
	
	

}
