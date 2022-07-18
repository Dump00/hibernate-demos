package com.cisco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item implements Serializable {
    @Id
    private String code;
    @Column(nullable = false)
    private String description;
    @Column(name = "qty_on_hand",nullable = false)
    private int qtyOnHand;
    @Column(name = "unit_price",nullable = false)
    private BigDecimal unitPrice;
}
