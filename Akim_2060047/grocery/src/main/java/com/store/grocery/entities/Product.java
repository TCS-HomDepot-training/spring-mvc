package com.store.grocery.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="UnitPrice")
	private Double unitPrice;
	
	@Column(name="Discount")
	private Double discount;
	
	@Column(name="Lastupdatetime")
	private LocalDate lastUpdateTime;
	
	public Product() {
	}
	public Product(Integer id, String name, Double unitPrice, Double discount, LocalDate lastUpdateTime) {
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.lastUpdateTime = lastUpdateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public LocalDate getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(LocalDate lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
}
