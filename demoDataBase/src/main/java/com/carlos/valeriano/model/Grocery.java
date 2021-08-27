package com.carlos.valeriano.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "GROCERY")
public class Grocery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NAME")
	@NotNull
	@Size(min = 1, max = 50, message = "The length of the name must be between 1 and 50 characters")
	private String name;

	@Column(name = "UNIT_PRICE")
	@NotNull
	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer = 6, fraction = 2)
	private BigDecimal unitPrice;

	@Column(name = "DISCOUNT")
	@NotNull
	@Digits(integer = 6, fraction = 2)
	private BigDecimal discount;

	@Column(name = "LAST_UPDATE_TIME")
	@NotNull
	private Timestamp lastUpdateTime;

	public Grocery() {

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

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Grocery))
			return false;
		Grocery grocery = (Grocery) o;
		return Objects.equals(this.id, grocery.id) && Objects.equals(this.name, grocery.name)
				&& Objects.equals(this.unitPrice, grocery.unitPrice) && Objects.equals(this.discount, grocery.discount)
				&& Objects.equals(this.lastUpdateTime, grocery.lastUpdateTime);

	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.unitPrice, this.discount, this.lastUpdateTime);
	}

	@Override
	public String toString() {
		return "Grocery [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", discount=" + discount
				+ ", lastUpdateTime=" + lastUpdateTime + "]";
	}

}
