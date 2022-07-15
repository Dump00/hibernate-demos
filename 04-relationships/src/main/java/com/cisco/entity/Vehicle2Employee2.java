package com.cisco.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle2_employee2")
public class Vehicle2Employee2 implements Serializable {
    @EmbeddedId
    private Vehicle2Employee2PK vehicle2Employee2PK;
    private Date date;
    @Setter(AccessLevel.NONE)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "number", referencedColumnName = "number", insertable = false, updatable = false)
    private Vehicle2 vehicle2;
    @Setter(AccessLevel.NONE)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Employee2 employee2;


    public Vehicle2Employee2(String number, String id, Date date) {
        this.vehicle2Employee2PK = new Vehicle2Employee2PK(number, id);
        this.date = date;
    }

    public Vehicle2Employee2(Vehicle2Employee2PK vehicle2Employee2PK, Date date) {
        this.vehicle2Employee2PK = vehicle2Employee2PK;
        this.date = date;
    }
}
