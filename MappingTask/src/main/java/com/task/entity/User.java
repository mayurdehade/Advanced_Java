package com.task.entity;

public class User {

	private int id;
	private String username;
	private String password;
	private String gender;
	private String mailId;

	public User() {
		super();
	}

	public User(int id, String username, String password, String gender, String mailId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.mailId = mailId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", gender=" + gender
				+ ", mailId=" + mailId + "]";
	}

}
