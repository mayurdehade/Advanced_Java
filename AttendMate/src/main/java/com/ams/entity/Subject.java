package com.ams.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Subject {
	@Id
	private long id; // Assuming you prefer long data type for id
	private String name;
	private String code;
}
