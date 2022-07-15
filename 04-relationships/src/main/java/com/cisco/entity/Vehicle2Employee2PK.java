package com.cisco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Vehicle2Employee2PK implements Serializable {
    @Column(unique = true)
    private String number;
    @Column(unique = true)
    private String id;
}
