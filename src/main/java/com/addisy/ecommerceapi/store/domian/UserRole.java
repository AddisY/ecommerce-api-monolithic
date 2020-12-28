package com.addisy.ecommerceapi.store.domian;

import java.io.Serializable;

import javax.persistence.*;

import com.addisy.ecommerceapi.store.domian.Role;
import com.addisy.ecommerceapi.store.domian.User;

@Entity
@Table(name="user_role")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 89374L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userRoleId;

	public UserRole () {}

	public UserRole (User user, Role role) {
		this.user = user;
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


}

