package com.cisco.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle2")
public class Vehicle2 implements Serializable {
    @Id
    private String number;
    @Column(nullable = false)
    private String type;
    @Setter(AccessLevel.NONE)
    @OneToOne(mappedBy = "vehicle2", cascade = CascadeType.PERSIST)
    private Vehicle2Employee2 vehicle2Employee2;

    public Vehicle2(String number, String type) {
        this.number = number;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vehicle2{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

