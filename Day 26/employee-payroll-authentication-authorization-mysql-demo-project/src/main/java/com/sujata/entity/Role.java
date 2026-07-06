package com.sujata.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "ROLES")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;

	@Column(unique = true)
	private String roleName;

	public Role() {
	}
	public Role(Long roleId, String roleName) {
	    this.roleId = roleId;
	    this.roleName = roleName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
}