package com.cisco.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bill_detail")
public class BillDetail implements Serializable {
    @EmbeddedId
    private BillDetailPK billDetailPK;
    @Column(nullable = false)
    private int qty;
    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;
    @Setter(AccessLevel.NONE)
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    private Item item;
    @Setter(AccessLevel.NONE)
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bill_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Bill bill;

    public BillDetail(String itemCode, String billId, int qty, BigDecimal unitPrice) {
        this.billDetailPK = new BillDetailPK(itemCode, billId);
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public BillDetail(BillDetailPK billDetailPK, int qty, BigDecimal unitPrice) {
        this.billDetailPK = billDetailPK;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
}
