package ke.co.turbosoft.med.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

/**
 * Created by ktonym on 1/9/15.
 */
@Entity
public class BankDetail {

    private String name;
    private String branch;
    private int accountNo;
    @OneToOne
    // TODO consider using primaryKeyJoinColumn here!!
    @PrimaryKeyJoinColumn
    private Provider provider;
    @OneToMany(mappedBy = "bankDetail")
    private List<Payment> payments;

}
