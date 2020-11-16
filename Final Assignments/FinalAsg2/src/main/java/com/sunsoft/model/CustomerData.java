package com.sunsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="CustomerData")
public class CustomerData implements Serializable{
	@Id
	@Column
	int id;
	@Column
	String name;
	@Column
	int tenure;
	@Column
	int amount;
	public CustomerData() {};
	
	public CustomerData(int no, String name, int tenure, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.tenure = tenure;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
