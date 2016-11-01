package com.cybage.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cybage.utility.Util;





@Entity
@Table(name="officeclientlnk")
public class Officeclientlnk implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	
	@Column(name="LOCATION",length=30,nullable=false)
	private String location;
	
	@Column(name="ADDRESS",length=45,nullable=false)
	private String address;
	
	@ManyToOne
	@JoinColumn(name="CLIENTID", referencedColumnName ="ID")
	private Client client;

	//default constructor
	public Officeclientlnk() {
		super();
		this.id =Util.getUUID();
		// TODO Auto-generated constructor stub
	}

	//parameterized constructor
	public Officeclientlnk(String id, String location, String address, Client client) {
		super();
	
		this.location = location;
		this.address = address;
		this.client = client;
	}

	//getter-setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Officeclientlnk [id=" + id + ", location=" + location + ", address=" + address + ", client=" + client
				+ "]";
	}
	
	
	
	
	
}
