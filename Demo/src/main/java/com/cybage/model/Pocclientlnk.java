package com.cybage.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cybage.utility.Util;




@Entity
@Table(name="pocclientlnk")
public class Pocclientlnk implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    private String id;
    
	@ManyToOne
	@JoinColumn(name="CLIENTID",referencedColumnName="ID")
	private Client client;
	
	
	@ManyToOne
	@JoinColumn(name="USERID",referencedColumnName="ID")
	private User user;

	//default constructor
	public Pocclientlnk() {
		super();
		this.id =Util.getUUID();
		// TODO Auto-generated constructor stub
	}

	//parameterized constructor
	public Pocclientlnk(Client client, User user) {
		super();
	
		this.client = client;
		this.user = user;
	}
	//getter-setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Pocclientnk [id=" + id + ", client=" + client + ", user=" + user + "]";
	}

	
	

	
	


	
	
	
	
    
}
