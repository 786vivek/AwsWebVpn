package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
//import org.antlr.v4.runtime.misc.NotNull;
//import javax.validation.Valid;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
//@GeneratedValue(strategy = GenerationType.IDENTITY)
public class User implements Serializable {
	// erialVersionUID = 1L;
	private static final long serialVersionUID = -389791385625057693L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String email;

	// private String password;

	private String role;

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", role=" + role + ", name=" + name + ", password=" + password
				+ ", isDeleted=" + isDeleted + "]";
	}

	public User(Integer id, String email, String role, @NotNull(message = "Name cannot be null") String name,
			String password, Boolean isDeleted) {
		super();
		this.id = id;
		this.email = email;
		this.role = role;
		this.name = name;
		this.password = password;
		this.isDeleted = isDeleted;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@NotNull(message = "Name cannot be null")
	@Column(nullable = false)
	private String name;

	private String password;
	private Boolean isDeleted = false;

}
