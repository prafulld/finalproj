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
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "USERNAME", length = 30, nullable = false)
	private String username;

	@Column(name = "PASSWORD", length = 70, nullable = false)
	private String password;

	@Column(name = "FNAME", length = 30, nullable = false)
	private String fname;

	@Column(name = "MNAME", length = 30, nullable = false)
	private String mname;

	@Column(name = "LNAME", length = 30, nullable = false)
	private String lname;

	@Column(name = "GENDER", length = 1, nullable = false)
	private String gender;

	@Column(name = "STATUS", length = 36, nullable = false)
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

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Userrolelnk> userrolelinks;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Usergrouplnk> usergrouplinks;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Userpermissionlnk> userpermissionlinks;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Pocclientlnk> pocclientlinks;

	// default constructor
	public User() {
		super();
		this.id = Util.getUUID();
		this.modified=new Date();
		this.created=new Date();
	}

	// parameterized constructor
	public User(String username, String password, String fname, String mname, String lname, String gender,
			String status, Timestamp created, String createdby, Timestamp modified, String modifiedby) {
		super();

		this.username = username;
		this.password = password;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.gender = gender;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public List<Userrolelnk> getUserrolelinks() {
		return userrolelinks;
	}

	public void setUserrolelinks(List<Userrolelnk> userrolelinks) {
		this.userrolelinks = userrolelinks;
	}

	public List<Usergrouplnk> getUsergrouplinks() {
		return usergrouplinks;
	}

	public void setUsergrouplinks(List<Usergrouplnk> usergrouplinks) {
		this.usergrouplinks = usergrouplinks;
	}

	public List<Userpermissionlnk> getUserpermissionlinks() {
		return userpermissionlinks;
	}

	public void setUserpermissionlinks(List<Userpermissionlnk> userpermissionlinks) {
		this.userpermissionlinks = userpermissionlinks;
	}

	public List<Pocclientlnk> getPocclientlinks() {
		return pocclientlinks;
	}

	public void setPocclientlinks(List<Pocclientlnk> pocclientlinks) {
		this.pocclientlinks = pocclientlinks;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", fname=" + fname + ", mname="
				+ mname + ", lname=" + lname + ", gender=" + gender + ", status=" + status + ", created=" + created
				+ ", createdby=" + createdby + ", modified=" + modified + ", modifiedby=" + modifiedby + "]";
	}

}
