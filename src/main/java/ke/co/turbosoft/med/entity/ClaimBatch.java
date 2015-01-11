package ke.co.turbosoft.med.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ktonym on 1/9/15.
 */
@Entity
public class ClaimBatch extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String batchNo;
    @ManyToOne
    @JoinColumn(name="voucher_id",nullable = false)
    private PaymentVoucher voucher;
    @OneToMany(mappedBy = "batch")
    private List<Bill> bills;

    public ClaimBatch() {
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public PaymentVoucher getVoucher() {
        return voucher;
    }

    public void setVoucher(PaymentVoucher voucher) {
        this.voucher = voucher;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
