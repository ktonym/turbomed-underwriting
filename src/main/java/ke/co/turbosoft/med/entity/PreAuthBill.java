package ke.co.turbosoft.med.entity;

import javax.persistence.*;

/**
 * Created by ktonym on 1/10/15.
 */
@Entity @IdClass(PreAuthBillId.class)
//@Table(uniqueConstraints={@UniqueConstraint(columnNames="bill_id")})
public class PreAuthBill {

    @Id
    @ManyToOne
    @JoinColumn(name = "bill_id",nullable = false,unique=true)
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
