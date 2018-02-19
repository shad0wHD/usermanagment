package com.gabor.usermanagment.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "tbl_customer")
public class Customer {

	@Id
	@GeneratedValue 
	@Column(name="customerID")
	private long customerID;
	@Column(name="customerName")
	@NotBlank
	private String customerName;
	@Column(name="customerAddress")
	@NotBlank
	private String customerAddress;
	@Column(name="customerPhoneNumber")
	@NotBlank
	private String customerPhoneNumber;

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;

	}

	public Customer() {
		super();
	}

	public Customer(long customerID, String customerName, String customerAddress, String customerPhoneNumber) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhoneNumber = customerPhoneNumber;

	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerPhoneNumber=" + customerPhoneNumber + "]";
	}

}
