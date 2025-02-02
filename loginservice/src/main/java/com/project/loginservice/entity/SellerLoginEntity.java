package com.project.loginservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class SellerLoginEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "username")
	String username;
	@Column(name = "password")
	String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SellerLoginEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public SellerLoginEntity() {
		super();
	}

	@Override
	public String toString() {
		return "SellerLoginEntity [username=" + username + ", password=" + password + "]";
	}

}
