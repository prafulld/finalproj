package com.cybage.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cybage.utility.Util;




@Entity
@Table(name="usergrouplnk")
public class Usergrouplnk implements Serializable{

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
	@JoinColumn(name="GROUPID",referencedColumnName="ID")
	private Group group;

	//default constructor
	public Usergrouplnk() {
		super();
		this.id =Util.getUUID();
		// TODO Auto-generated constructor stub
	}

	//parameterized constructor
	public Usergrouplnk(User user, Group group) {
		super();
		
		this.user = user;
		this.group = group;
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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Usergrouplnk [id=" + id + ", user=" + user + ", group=" + group + "]";
	}

	
	
	
	
    
}
