package ke.co.turbosoft.med.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by ktonym on 1/9/15.
 */
@Entity
public class Bill extends AbstractEntity {

    private String invoiceNo;
    private String claimNo;
    @Convert(converter=LocalDatePersistenceConverter.class)
    private LocalDate invoiceDate;
    private BigDecimal invoiceAmt;
    private BigDecimal deductionAmt;
    private String deductionReason;
    @Convert(converter=LocalDatePersistenceConverter.class)
    private LocalDate enteredDate;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "member_id",referencedColumnName = "member_id"),
            @JoinColumn(name = "benefit_id",referencedColumnName = "benefit_id")
    })
    private CorpMemberBenefit memberBenefit;
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;
    @ManyToOne
    @JoinColumn(name = "batch_id")
    private ClaimBatch batch;

    // TODO create: ClaimBatch>--|-PaymentVoucher-|--0-BillPayment(cheque)>--|-BankDetails
    // TODO BankDetails-0--|-Provider
}
