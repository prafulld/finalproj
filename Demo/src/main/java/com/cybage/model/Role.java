package com.cybage.model;
import java.io.Serializable;
import java.sql.Timestamp;
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
@Table(name = "role")
public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "NAME", length = 30, nullable = false)
	private String name;

	@Column(name = "DESCRIPTION", length = 255, nullable = false)
	private String description;

	@Column(name = "STATUS", length = 8, nullable = false)
	private String status;

	@Column(name = "TYPE", length = 7, nullable = false)
	private String type;

	@Column(name = "CREATED", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name = "CREATEDBY", length = 36, nullable = true)
	private String createdby;

	@Column(name = "MODIFIED", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	@Column(name = "MODIFIEDBY", length = 36, nullable = true)
	private String modifiedby;

	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Userrolelnk> userrolelinks;

	// default constructor
	public Role() {
		super();
		this.id = Util.getUUID();
		this.modified=new Date();
		this.created=new Date();
	}

	// parameterized constructor
	public Role(String name, String description, String status, String type, Timestamp created, String createdby,
			Timestamp modified, String modifiedby) {
		super();

		this.name = name;
		this.description = description;
		this.status = status;
		this.type = type;
		this.created = created;
		this.createdby = createdby;
		this.modified = modified;
		this.modifiedby = modifiedby;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public List<Userrolelnk> getUserrolelinks() {
		return userrolelinks;
	}

	public void setUserrolelinks(List<Userrolelnk> userrolelinks) {
		this.userrolelinks = userrolelinks;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status + ", type="
				+ type + ", created=" + created + ", createdby=" + createdby + ", modified=" + modified
				+ ", modifiedby=" + modifiedby + "]";
	}

}
