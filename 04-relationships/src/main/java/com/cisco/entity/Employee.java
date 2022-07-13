package com.cisco.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @OneToOne(mappedBy = "employee", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Spouse spouse;
    @OneToOne(mappedBy = "employee", cascade = {CascadeType.PERSIST})
    private Vehicle vehicle;

    public Employee(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Employee(String id, String name, String address, Spouse spouse) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.spouse = spouse;
        this.spouse.setEmployee(this);
    }

    public Employee(String id, String name, String address, Vehicle vehicle) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.vehicle = vehicle;
        this.vehicle.setEmployee(this);
    }

    public Employee(String id, String name, String address, Spouse spouse, Vehicle vehicle) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.spouse = spouse;
        this.vehicle = vehicle;
        this.spouse.setEmployee(this);
        this.vehicle.setEmployee(this);
    }

    public void setSpouse(Spouse spouse) {
        spouse.setEmployee(this);
        this.spouse = spouse;
    }

    public void setVehicle(Vehicle vehicle) {
        vehicle.setEmployee(this);
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
