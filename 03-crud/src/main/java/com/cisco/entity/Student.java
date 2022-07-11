package com.cisco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    int id;
    @Column(nullable = false)
    String name;
    @Column(columnDefinition = "varchar(500)", nullable = false)
    String address;
    @Column(name = "contact_number", nullable = false)
    String contactNumber;
}
