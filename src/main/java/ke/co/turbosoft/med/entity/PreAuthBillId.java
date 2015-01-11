package ke.co.turbosoft.med.entity;

import java.io.Serializable;

/**
 * Created by ktonym on 1/10/15.
 */
public class PreAuthBillId implements Serializable {

    Bill bill;
    PreAuth preAuth;

    public PreAuthBillId() {
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
