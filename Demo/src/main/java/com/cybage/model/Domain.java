package com.cybage.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cybage.utility.Util;





@Entity
@Table(name="domain")
public class Domain implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Column(name="NAME",length=30,nullable=false,unique=true)
	private String name;
	
	
	@OneToMany(mappedBy="domain",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Clientdomainlnk>clientdomainlinks;

	

	//default constructor
	public Domain() {
		super();
		this.id =Util.getUUID();
		// TODO Auto-generated constructor stub
	}

	//parameterized constructor
	public Domain(String name) {
		super();
		this.name = name;
	}

	//getter-setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Clientdomainlnk> getClientdomainlinks() {
		return clientdomainlinks;
	}

	public void setClientdomainlinks(List<Clientdomainlnk> clientdomainlinks) {
		this.clientdomainlinks = clientdomainlinks;
	}

	@Override
	public String toString() {
		return "Domain [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
