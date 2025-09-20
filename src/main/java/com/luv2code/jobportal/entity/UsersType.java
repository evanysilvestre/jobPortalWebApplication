package com.luv2code.jobportal.entity;
/*
 Entity → represents your database tables (part of the Model).
 */
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_type")
public class UsersType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userTypeId;
	
	private String userTypeName; //Recruiter or Jobseeker
	
	@OneToMany(targetEntity = Users.class, mappedBy = "userTypeId", cascade = CascadeType.ALL)
	private List<Users> users;
	/*if you have a UsersType with userTypeName = "Recruiter", the users list will hold all users who are recruiters.*/

	//Empty Constructor
	public UsersType() {

	}
	
	//Constructor with arguments
	public UsersType(int userTypeId, String userTypeName, List<Users> users) {
		super();
		this.userTypeId = userTypeId;
		this.userTypeName = userTypeName;
		this.users = users;
	}

	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UsersType [userTypeId=" + userTypeId + 
				", userTypeName=" + userTypeName + "]";
	}
	
	
}
