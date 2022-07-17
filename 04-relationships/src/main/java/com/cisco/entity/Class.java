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
@Table(name = "class")
public class Class implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String description;
    @OneToMany(mappedBy = "classRef", cascade = CascadeType.PERSIST)
    List<ClassStudent> classStudentList;

    public Class(String id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
