package com.rgcorporation.main.model;

public class LoginDetails {

	private int userId;
	private String password;
	private String role;

	public LoginDetails() {
	}

	public LoginDetails(int userId2, String password, String role) {
		super();
		this.userId = userId2;
		this.password = password;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginDetails [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}

}
