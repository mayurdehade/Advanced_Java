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
public class Product {

	@Id
	private String productId;
	private String productName;
	private String productCategory;
	private String productDescription;
	private int productQty;
	private float productPrice;
	private String manufacturer;
}
