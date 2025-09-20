package com.luv2code.jobportal.entity;
/*
 Entity → represents your database tables (part of the Model).*/
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@Column(unique = true)
	private String email;
	
	@NotEmpty
	private String password;
	
	private boolean isActive;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date registrationDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userTypeId", referencedColumnName = "userTypeId")
	private UsersType userTypeId;

	/**
	 * 
	 */
	public Users() {
	}

	/**
	 * @param id
	 * @param email
	 * @param password
	 * @param isActive
	 * @param registrationDate
	 * @param userTypeId
	 */
	public Users(int id, String email, @NotEmpty String password, boolean isActive, Date registrationDate,
			UsersType userTypeId) {
		super();
		Id = id;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.registrationDate = registrationDate;
		this.userTypeId = userTypeId;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public UsersType getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(UsersType userTypeId) {
		this.userTypeId = userTypeId;
	}

	@Override
	public String toString() {
		return "Users [Id=" + Id + 
				", "+ "email=" + email +
				", password=" + password + 
				", isActive=" + isActive+ 
				", registrationDate=" + registrationDate + 
				", userTypeId=" + userTypeId + "]";
	}

}
