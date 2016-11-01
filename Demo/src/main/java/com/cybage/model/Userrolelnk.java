package com.cybage.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cybage.utility.Util;




@Entity
@Table(name="userrolelnk")
public class Userrolelnk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    private String id;
    
	@ManyToOne
	@JoinColumn(name="USERID",referencedColumnName="ID")
	private User user;
	
	
	@ManyToOne
	@JoinColumn(name="ROLEID",referencedColumnName="ID")
	private Role role;

	//default constructor
	public Userrolelnk() {
		super();
		this.id =Util.getUUID();
		// TODO Auto-generated constructor stub
	}

	//parameterized constructor
	public Userrolelnk(User user, Role role) {
		super();
	
		this.user = user;
		this.role = role;
	}


	//getter-setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Userrolelnk [id=" + id + ", user=" + user + ", role=" + role + "]";
	}
	
	
	
    
}
