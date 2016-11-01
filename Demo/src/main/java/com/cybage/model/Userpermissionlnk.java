package com.cybage.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cybage.utility.Util;




@Entity
@Table(name="userpermissionlnk")
public class Userpermissionlnk implements Serializable{

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
	@JoinColumn(name="PERMISSIONID",referencedColumnName="ID")
	private Permission permission;

	//default constructor
	public Userpermissionlnk() {
		super();
		this.id =Util.getUUID();
		// TODO Auto-generated constructor stub
	}

	//parameterized constructor
	public Userpermissionlnk(User user, Permission permission) {
		super();
		
		this.user = user;
		this.permission = permission;
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

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "Userpermissionlnk [id=" + id + ", user=" + user + ", permission=" + permission + "]";
	}

	


	
	
	
	
    
}
