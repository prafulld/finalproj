package com.cybage.model;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cybage.utility.Util;




@Entity
@Table(name = "client")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "NAME", length = 30, nullable = false)
	private String name;

	@Column(name = "ADDRESS", length = 45, nullable = false)
	private String address;

	@Column(name = "DESCRIPTION", length = 255, nullable = false)
	private String description;

	@Column(name = "REVENUE", nullable = false)
	private double revenue;

	@Column(name = "EMPLOYEES", length = 11, nullable = false)
	private int employess;

	@Column(name = "PRESENCE", length = 30, nullable = false)
	private String presence;

	@Column(name = "CEO", length = 36, nullable = false)
	private String ceo;

	@Column(name = "CTO", length = 36, nullable = false)
	private String cto;

	@Column(name = "STATUS", length = 8, nullable = false)
	private String status;

	@Column(name = "CREATED", length = 30, nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name = "CREATEDBY", length = 30, nullable = true)
	private String createdby;

	@Column(name = "MODIFIED", length = 30, nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	@Column(name = "MODIFIEDBY", length = 30, nullable = true)
	private String modifiedby;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Clientdomainlnk> clientdomainlinks;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Pocclientlnk> pocclientlinks;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Officeclientlnk> officeclientlinks;

	// default constructor
	public Client() {
		super();
		this.id = Util.getUUID();
		this.modified=new Date();
		this.created=new Date();
		
	}

	// parameterized constructor
	public Client(String name, String address, String description, double revenue, int employess, String presence,
			String ceo, String cto, String status, Date created, String createdby, Date modified, String modifiedby,
			List<Clientdomainlnk> clientdomainlinks, List<Pocclientlnk> pocclientlinks,
			List<Officeclientlnk> officeclientlinks) {
		super();

		this.name = name;
		this.address = address;
		this.description = description;
		this.revenue = revenue;
		this.employess = employess;
		this.presence = presence;
		this.ceo = ceo;
		this.cto = cto;
		this.status = status;
		this.created = created;
		this.createdby = createdby;
		this.modified = modified;
		this.modifiedby = modifiedby;
		this.clientdomainlinks = clientdomainlinks;
		this.pocclientlinks = pocclientlinks;
		this.officeclientlinks = officeclientlinks;
	}

	// getter-setter
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public int getEmployess() {
		return employess;
	}

	public void setEmployess(int employess) {
		this.employess = employess;
	}

	public String getPresence() {
		return presence;
	}

	public void setPresence(String presence) {
		this.presence = presence;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getCto() {
		return cto;
	}

	public void setCto(String cto) {
		this.cto = cto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public List<Clientdomainlnk> getClientdomainlinks() {
		return clientdomainlinks;
	}

	public void setClientdomainlinks(List<Clientdomainlnk> clientdomainlinks) {
		this.clientdomainlinks = clientdomainlinks;
	}

	public List<Pocclientlnk> getPocclientlinks() {
		return pocclientlinks;
	}

	public void setPocclientlinks(List<Pocclientlnk> pocclientlinks) {
		this.pocclientlinks = pocclientlinks;
	}

	public List<Officeclientlnk> getOfficeclientlinks() {
		return officeclientlinks;
	}

	public void setOfficeclientlinks(List<Officeclientlnk> officeclientlinks) {
		this.officeclientlinks = officeclientlinks;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", address=" + address + ", description=" + description
				+ ", revenue=" + revenue + ", employess=" + employess + ", presence=" + presence + ", ceo=" + ceo
				+ ", cto=" + cto + ", status=" + status + ", created=" + created + ", createdby=" + createdby
				+ ", modified=" + modified + ", modifiedby=" + modifiedby + ", clientdomainlinks=" + clientdomainlinks
				+ ", pocclientlinks=" + pocclientlinks + ", officeclientlinks=" + officeclientlinks + "]";
	}

	
}
