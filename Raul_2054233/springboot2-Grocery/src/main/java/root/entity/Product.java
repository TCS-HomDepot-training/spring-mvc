package root.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;



@Entity(name = "Products")
public class Product {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_prod" )
	@SequenceGenerator(name = "sec_prod", sequenceName = "SEQ_PRODUCT", initialValue = 1, allocationSize = 1)
	int id;
	
	@Column(length = 50, nullable = false)
	String name;
	
	@Column(nullable = false)
	float unitPrice;
	
	@Column(nullable = true)
	float discount;
	
	@Column(nullable = false)
    private Date lastUpdateTime;

	public int getId() {
		return id;
	}

	public void setId(int idP) {
		this.id = idP;
	}

	public String getName() {
		return name;
	}

	public void setName(String nameP) {
		this.name = nameP;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPriceP) {
		this.unitPrice = unitPriceP;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discountP) {
		this.discount = discountP;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTimeP) {
		this.lastUpdateTime = lastUpdateTimeP;
	}

	

	
}
