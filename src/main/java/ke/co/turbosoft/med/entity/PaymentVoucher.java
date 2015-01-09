package ke.co.turbosoft.med.entity;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by ktonym on 1/9/15.
 */

@Entity
public class PaymentVoucher extends AbstractEntity{

    private String voucherNo;
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate voucherDate;
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate authorizedDate;
    @OneToOne(mappedBy = "voucher")
    private Payment payment;
    @OneToMany(mappedBy = "voucher")
    private List<ClaimBatch> batch;

}
