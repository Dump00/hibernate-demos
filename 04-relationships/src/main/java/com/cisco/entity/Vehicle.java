package com.cisco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {
    @Id
    private String number;
    @Column(nullable = false)
    private String type;
    @OneToOne
    @JoinTable(name = "vehicle_employee",
            joinColumns = @JoinColumn(name = "number", referencedColumnName = "number", unique = true),
            inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id", unique = true))
    private Employee employee;

    public Vehicle(String number, String type) {
        this.number = number;
        this.type = type;
    }
}
