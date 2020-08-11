package com.ipnetinstitute.csc394.backend.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	String firstName;
	String lastName;
	String userName;
	String phone;
	String email;
	String password;

	public User() {
	}

//	 @OneToMany(mappedBy = "user", cascade = { CascadeType.ALL }) private
//	 List<Student> student = new ArrayList<Student>();
	 

//	@OneToMany(mappedBy = "user", cascade =  CascadeType.ALL)
//	private Set<Teacher> teacher = new HashSet<>();
////	@JsonManagedReference
//	public Set<Teacher> getTeacher() {
//		return teacher;
//	}
//
//	public void setTeacher(Set<Teacher> teacher) {
//		this.teacher = teacher;
//	}

	@ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinTable( name = "user_role", joinColumns = {
			@JoinColumn( name = "id_user") },
			inverseJoinColumns = {
				@JoinColumn( name = "id_role")
			} )
	private Set<Role> roles = new HashSet<>();

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Set<Role> getRole() {
		return roles;
	}

	public void setRole(Set<Role> role) {
		this.roles = role;
	}

	public User(String firstName, String lastName, String userName, String phone, String email, String password, Set<Role> role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.roles = role;
	}
}
