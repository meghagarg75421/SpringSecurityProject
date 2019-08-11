package com.example.dataobjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="rolevalues")
public class RoleTable {

	public RoleTable() {}
	
	public RoleTable(Integer roleid, MyRole roleName, User user) {
		super();
		this.roleid = roleid;
		this.roleName = roleName;
		this.user = user;
	}

	@GeneratedValue
	@Id
	private Integer roleid;
	
	@Column(name="rolename")
	@Enumerated (EnumType.STRING)
	private MyRole roleName;
	
	@OneToOne
    @JoinColumn(name = "Id")
	@JsonIgnore
	private User user;

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public MyRole getRoleName() {
		return roleName;
	}

	public void setRoleName(MyRole roleName) {
		this.roleName = roleName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
