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
@Table(name = "vehicle2")
public class Vehicle2 implements Serializable {
    @Id
    private String number;
    @Column(nullable = false)
    private String type;

}

