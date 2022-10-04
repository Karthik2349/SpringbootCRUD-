package com.department.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long depid;
	@Column(name="depname",nullable=false)
	private String depname;
	@Column(name="email")
	private String email;
	@Column(name="depcode")
	private String depcode;
	public long getDepid() {
		return depid;
	}
	public void setDepid(long depid) {
		this.depid = depid;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getDepcode() {
		return depcode;
	}
	public void setDepcode(String depcode) {
		this.depcode = depcode;
	}
	public Department(String depname, String email) {
		this.depname = depname;
		this.email = email;
	}
	public Department() {
		super();
	}
	
	 

}
