package ke.co.turbosoft.med.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by ktonym on 1/9/15.
 */
@Entity
public class ClaimBatch extends AbstractEntity {

    private String batchNo;
    @ManyToOne
    @JoinColumn(name="voucher_id")
    private PaymentVoucher voucher;
    @OneToMany(mappedBy = "batch")
    private List<Bill> bills;

}
