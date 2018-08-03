package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier {
	@Id
	@GeneratedValue
	int sup_id;
	String dealer_Name;
	String dealer_desc;
	String dealer_address;
	public int getSup_id() {
		return sup_id;
	}
	public void setSup_id(int sup_id) {
		this.sup_id = sup_id;
	}
	public String getDealer_Name() {
		return dealer_Name;
	}
	public void setDealer_Name(String dealer_Name) {
		this.dealer_Name = dealer_Name;
	}
	public String getDealer_desc() {
		return dealer_desc;
	}
	public void setDealer_desc(String dealer_desc) {
		this.dealer_desc = dealer_desc;
	}
	public String getDealer_address() {
		return dealer_address;
	}
	public void setDealer_address(String dealer_address) {
		this.dealer_address = dealer_address;
	}
	

}
