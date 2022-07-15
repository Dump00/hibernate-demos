package com.cisco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order2")
public class Order2 implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private Date date;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinTable(name = "customer2_order2",
                        joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
                        inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
    private Customer2 customer2;

    public Order2(String id, Date date) {
        this.id = id;
        this.date = date;
    }
}
