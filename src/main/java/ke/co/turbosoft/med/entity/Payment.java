package ke.co.turbosoft.med.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by ktonym on 1/9/15.
 */
@Entity
public class Payment extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "bank_id",nullable = false)
    private BankDetail bankDetail;
    @Column(nullable = false,unique = true)
    private String chequeNo;
    @Column(nullable = false)
    private BigDecimal chequeAmt;
    @Column(nullable = false)
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate chequeDate;
    @Column(nullable = false)
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate dispatchDate;
    @OneToOne // TODO primaryKeyJoinColumn??
    @Column(unique = true,nullable = false)
    private PaymentVoucher voucher;
    @OneToOne(mappedBy = "payment")
    private PaymentCancellation paymentCancellation;

    public Payment() {
    }

    public BankDetail getBankDetail() {
        return bankDetail;
    }

    public void setBankDetail(BankDetail bankDetail) {
        this.bankDetail = bankDetail;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public BigDecimal getChequeAmt() {
        return chequeAmt;
    }

    public void setChequeAmt(BigDecimal chequeAmt) {
        this.chequeAmt = chequeAmt;
    }

    public LocalDate getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(LocalDate chequeDate) {
        this.chequeDate = chequeDate;
    }

    public LocalDate getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(LocalDate dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public PaymentVoucher getVoucher() {
        return voucher;
    }

    public void setVoucher(PaymentVoucher voucher) {
        this.voucher = voucher;
    }

    public PaymentCancellation getPaymentCancellation() {
        return paymentCancellation;
    }

    public void setPaymentCancellation(PaymentCancellation paymentCancellation) {
        this.paymentCancellation = paymentCancellation;
    }

}
