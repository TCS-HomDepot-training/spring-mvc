package com.store.grocery.dto;

import java.io.Serializable;
import java.time.LocalDate;


public class ProductDTO implements Serializable{
	
	private static final long serialVersionUID = 4396242677704935084L;

	private int id;
	
	private String name;
	
	private double unitPrice;
	
	private double discount;
	
	private LocalDate lastUpdateTime;

	public ProductDTO(int id, String name, double unitPrice, double discount, LocalDate lastUpdateTime) {
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.lastUpdateTime = lastUpdateTime;
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

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public LocalDate getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(LocalDate lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
}
