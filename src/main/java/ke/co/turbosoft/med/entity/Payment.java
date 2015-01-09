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
    @JoinColumn(name = "bank_id")
    private BankDetail bankDetail;
    private String chequeNo;
    private BigDecimal chequeAmt;
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate chequeDate;
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate dispatchDate;
    @OneToOne // TODO primaryKeyJoinColumn??
    private PaymentVoucher voucher;

    // TODO complete the other properties
}
