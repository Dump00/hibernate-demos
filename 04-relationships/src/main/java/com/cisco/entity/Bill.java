package com.cisco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bill")
public class Bill implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private Date date;
    @OneToMany(mappedBy = "bill", cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private List<BillDetail> billDetailList;

    public Bill(String id, Date date) {
        this.id = id;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", date=" + date +
                '}';
    }
}
