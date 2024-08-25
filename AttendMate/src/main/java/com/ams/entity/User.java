package com.ams.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
	@Id
	private String username;
	private String password;
	private String email;
	private String mobile;
	private String firstName;
	private String lastName;
}
