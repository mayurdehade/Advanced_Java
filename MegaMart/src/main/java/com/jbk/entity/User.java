package com.jbk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
	@Id
	private String username;
	private String name;
	private String email;
	private String gender;
	private long phoneNumber;
	private String password;
	
}
