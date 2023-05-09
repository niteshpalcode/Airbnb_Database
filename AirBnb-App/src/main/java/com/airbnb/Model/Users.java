package com.airbnb.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;
	@Column(name = "firstname",nullable = false,length = 15)
	private String firstname;
	@Column(name = "lastname",nullable = false,length = 15)
	private String lastname;
	@Column(name = "email",nullable = false,length=100)
	private String email;
	@Column(name = "password")
	private String password;
	
	
	
	@ManyToMany
	@JoinTable(name="UserRoles",
		joinColumns = @JoinColumn(name="user_Id", referencedColumnName = "userid"),
		inverseJoinColumns = @JoinColumn(name="role_Id", referencedColumnName = "roleId"))
	@JsonIgnore
	private List<Roles> roles=new ArrayList<>();
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
	@JsonIgnore
	private List<Bookings> allBookings=new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	private List<Listing> listing=new ArrayList<>();
	
	
	
	
}
