package ke.co.turbosoft.med.entity;

import javax.persistence.*;

/**
 * Created by ktonym on 1/10/15.
 */
@Entity @IdClass(PreAuthBillId.class)
public class PreAuthBill {

    @Id
    @OneToOne
    @Column(unique = true,nullable = false)
    private Bill bill;
    @Id
    @ManyToOne
    @JoinColumn(name = "preAuth_id",nullable = false)
    private PreAuth preAuth;

    public PreAuthBill() {
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public PreAuth getPreAuth() {
        return preAuth;
    }

    public void setPreAuth(PreAuth preAuth) {
        this.preAuth = preAuth;
    }
}
