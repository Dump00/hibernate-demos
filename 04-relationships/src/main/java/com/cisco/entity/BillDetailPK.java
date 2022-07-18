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
public class BillDetailPK implements Serializable {
    @Column(name = "item_code")
    private String itemCode;
    @Column(name = "bill_id")
    private String billId;
}
