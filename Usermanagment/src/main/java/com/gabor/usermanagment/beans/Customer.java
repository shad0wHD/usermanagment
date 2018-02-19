package com.gabor.usermanagment.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_customer")
public class Customer {

	@Id
	@GeneratedValue 
	@Column(name="customerID")
	private long customerID;
	@Column(name="customerName")
	private String customerName;
	@Column(name="customerAddress")
	private String customerAddress;
	@Column(name="customerPhonenNumber")
	private String customerPhonenNumber;

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

	public String getCustomerPhonenNumber() {
		return customerPhonenNumber;
	}

	public void setCustomerPhonenNumber(String customerPhonenNumber) {
		this.customerPhonenNumber = customerPhonenNumber;

	}

	public Customer() {
		super();
	}

	public Customer(long customerID, String customerName, String customerAddress, String customerPhonenNumber) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhonenNumber = customerPhonenNumber;

	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerPhonenNumber=" + customerPhonenNumber + "]";
	}

}
