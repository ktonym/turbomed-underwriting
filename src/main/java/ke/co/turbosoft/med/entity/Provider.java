package ke.co.turbosoft.med.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Created by akipkoech on 12/8/14.
 */
@Entity
public class Provider extends AbstractEntity {

    @Column(nullable = false,unique = true)
    private String name;
    private String physicalAddress;
    private String town;
    @OneToMany(mappedBy = "provider")
    private List<CoPay> coPayList;
    @OneToOne(mappedBy = "provider")
    private BankDetail bankDetail;
    @OneToMany(mappedBy = "provider")
    private List<Bill> bills;

    public Provider() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public List<CoPay> getCoPayList() {
        return coPayList;
    }

    public void setCoPayList(List<CoPay> coPayList) {
        this.coPayList = coPayList;
    }

    public BankDetail getBankDetail() {
        return bankDetail;
    }

    public void setBankDetail(BankDetail bankDetail) {
        this.bankDetail = bankDetail;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
