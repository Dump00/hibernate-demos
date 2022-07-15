package com.cisco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer2")
public class Customer2 implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @OneToMany(mappedBy = "customer2")
    private List<Order2> order2List;

    public Customer2(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void setOrder2List(List<Order2> order2List) {
        order2List.forEach(order2 -> order2.setCustomer2(this));
        this.order2List = order2List;
    }

    public void addOrder(Order2 order2) {
        order2.setCustomer2(this);
        this.getOrder2List().add(order2);
    }

    public void removeOrder(Order2 order2) {
        this.order2List.remove(order2);
        order2.setCustomer2(null);
    }

    @Override
    public String toString() {
        return "Customer2{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
