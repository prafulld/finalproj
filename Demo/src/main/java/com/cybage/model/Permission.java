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
@Table(name = "permission")
public class Permission implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "NAME", length = 30, nullable = false)
	private String name;

	@Column(name = "DESCRIPTION", length = 255, nullable = false)
	private String description;

	@Column(name = "STATUS", length = 8, nullable = false)
	private String status;

	@Column(name = "TYPECD", length = 1, nullable = false)
	private String typecd;

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

	@OneToMany(mappedBy = "permission", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Userpermissionlnk> userpermissionlinks;

	// default constructor
	public Permission() {
		super();
		this.id = Util.getUUID();
		this.modified=new Date();
		this.created=new Date();
		// TODO Auto-generated constructor stub
	}

	// parameterized constructor
	public Permission(String name, String description, String status, String typecd, Timestamp created,
			String createdby, Timestamp modified, String modifiedby) {
		super();

		this.name = name;
		this.description = description;
		this.status = status;
		this.typecd = typecd;
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

	public String getTypecd() {
		return typecd;
	}

	public void setTypecd(String typecd) {
		this.typecd = typecd;
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

	public List<Userpermissionlnk> getUserpermissionlinks() {
		return userpermissionlinks;
	}

	public void setUserpermissionlinks(List<Userpermissionlnk> userpermissionlinks) {
		this.userpermissionlinks = userpermissionlinks;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
				+ ", typecd=" + typecd + ", created=" + created + ", createdby=" + createdby + ", modified=" + modified
				+ ", modifiedby=" + modifiedby + "]";
	}

}
