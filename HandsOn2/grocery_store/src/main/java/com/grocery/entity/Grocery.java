package com.grocery.entity;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
public class Grocery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private BigDecimal unitPrice;
    private BigDecimal discount;
    @UpdateTimestamp
    private Date lastUpdateTime;

}
