package com.tka.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	private int aid;
	private String city;
	private int pincode;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int aid, String city, int pincode) {
		super();
		this.aid = aid;
		this.city = city;
		this.pincode = pincode;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	
	
	
}
