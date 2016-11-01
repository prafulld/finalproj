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
@Table(name = "group")
public class Group implements Serializable {

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

	@OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Usergrouplnk> usergrouplinks;

	// default constructor
	public Group() {
		super();
		this.id = Util.getUUID();
		this.modified=new Date();
		this.created=new Date();
		// TODO Auto-generated constructor stub
	}

	// parameterized constructor
	public Group(String name, String description, String status, Timestamp created, String createdby,
			Timestamp modified, String modifiedby) {
		super();

		this.name = name;
		this.description = description;
		this.status = status;
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

	public List<Usergrouplnk> getUsergrouplinks() {
		return usergrouplinks;
	}

	public void setUsergrouplinks(List<Usergrouplnk> usergrouplinks) {
		this.usergrouplinks = usergrouplinks;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
				+ ", created=" + created + ", createdby=" + createdby + ", modified=" + modified + ", modifiedby="
				+ modifiedby + "]";
	}

}
