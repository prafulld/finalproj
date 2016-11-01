package com.cybage.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cybage.utility.Util;





@Entity
@Table(name="clientdomainlnk")
public class Clientdomainlnk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    private String id;
    
	@ManyToOne
	@JoinColumn(name="CLIENTID",referencedColumnName="ID")
	private Client client;
	
	
	@ManyToOne
	@JoinColumn(name="DOMAINID",referencedColumnName="ID")
	private Domain domain;

	//default constructor
	public Clientdomainlnk() {
		super();
		this.id =Util.getUUID();
		// TODO Auto-generated constructor stub
	}

	//parameterized constructor
	public Clientdomainlnk(Client client, Domain domain) {
		super();
		
		this.client = client;
		this.domain = domain;
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

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		return "Clientdomainlnk [id=" + id + ", client=" + client + ", domain=" + domain + "]";
	}

	
	


	
	
	
	
    
}
