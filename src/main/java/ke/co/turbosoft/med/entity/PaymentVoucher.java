package ke.co.turbosoft.med.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by ktonym on 1/9/15.
 */

@Entity
public class PaymentVoucher extends AbstractEntity{

    @Column(nullable = false,unique = true)
    private String voucherNo;
    @Convert(converter = LocalDatePersistenceConverter.class)
    @Column(nullable = false,unique = true)
    private LocalDate voucherDate;
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate authorizedDate;
    @OneToOne(mappedBy = "voucher")
    private Payment payment;
    @OneToMany(mappedBy = "voucher")
    private List<ClaimBatch> batch;
    @OneToOne(optional=false)
    private BillVet billVet;

    public PaymentVoucher() {
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public LocalDate getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(LocalDate voucherDate) {
        this.voucherDate = voucherDate;
    }

    public LocalDate getAuthorizedDate() {
        return authorizedDate;
    }

    public void setAuthorizedDate(LocalDate authorizedDate) {
        this.authorizedDate = authorizedDate;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<ClaimBatch> getBatch() {
        return batch;
    }

    public void setBatch(List<ClaimBatch> batch) {
        this.batch = batch;
    }

    public BillVet getBillVet() {
        return billVet;
    }

    public void setBillVet(BillVet billVet) {
        this.billVet = billVet;
    }
}
