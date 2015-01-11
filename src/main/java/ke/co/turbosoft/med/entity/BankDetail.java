package ke.co.turbosoft.med.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ktonym on 1/9/15.
 */
@Entity
public class BankDetail {

    private String name;
    private String branch;
    @Column(nullable = false, unique = true)
    private int accountNo;
    @OneToOne
    // TODO consider using primaryKeyJoinColumn here!!
   // @PrimaryKeyJoinColumn
    @Column(nullable = false, unique = true)
    private Provider provider;
    @OneToMany(mappedBy = "bankDetail")
    private List<Payment> payments;

    public BankDetail() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
