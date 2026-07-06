package com.sujata.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(unique = true)
	private String username;

	private String password;

	private boolean enabled = true;

	@ManyToMany(fetch = FetchType.EAGER)

	@JoinTable(name = "USER_ROLES",

			joinColumns = @JoinColumn(name = "USER_ID"),

			inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))

	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}