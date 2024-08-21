package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Lambok will automatically generate getter setter, constructor and to string 
//Lambok annotations
@Data //provide getter setter
@NoArgsConstructor //provide default constructor
@AllArgsConstructor //provide parameterize constructor
@ToString //provide to string
@Entity
@Table(name = "address")
public class Address {

	@Id
	private int addressId;
	private String street;
	private String city;
	private String state;
	private int zipCode;
	private String country;

//	public Address() {
//		super();
//	}
//
//	public Address(int addressId, String street, String city, String state, int zipCode, String country) {
//		super();
//		this.addressId = addressId;
//		this.street = street;
//		this.city = city;
//		this.state = state;
//		this.zipCode = zipCode;
//		this.country = country;
//	}
//
//	public int getAddressId() {
//		return addressId;
//	}
//
//	public void setAddressId(int addressId) {
//		this.addressId = addressId;
//	}
//
//	public String getStreet() {
//		return street;
//	}
//
//	public void setStreet(String street) {
//		this.street = street;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}
//
//	public int getZipCode() {
//		return zipCode;
//	}
//
//	public void setZipCode(int zipCode) {
//		this.zipCode = zipCode;
//	}
//
//	public String getCountry() {
//		return country;
//	}
//
//	public void setCountry(String country) {
//		this.country = country;
//	}
//
//	@Override
//	public String toString() {
//		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state
//				+ ", zipCode=" + zipCode + ", country=" + country + "]";
//	}

}
