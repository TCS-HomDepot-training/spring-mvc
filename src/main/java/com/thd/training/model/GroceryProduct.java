package com.thd.training.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="grocery_products", schema="trainee_schema")
public class GroceryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="GP_IdInt")
    private Integer id;

    @Column(name="GP_NameStr", nullable = false)
    private String name;

    @JsonProperty("unit_price")
    @Column(name="GP_UnitPriceDec", nullable = false)
    private Double unitPrice;

    @Column(name="GP_DiscountDec", nullable = true)
    private Double discount = 0.0d;

    @JsonProperty("last_update_time")
    @Column(name="GP_LastUpdateTimeDate")
    private Date lastUpdateTime = new Date();

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

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double UnitPrice) {
        this.unitPrice = UnitPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        lastUpdateTime = lastUpdateTime;
    }
}
