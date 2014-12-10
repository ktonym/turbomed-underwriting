package ke.co.turbosoft.med.entity;

import javax.persistence.*;

/**
 * Created by akipkoech on 12/9/14.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="RI_TYPE",discriminatorType = DiscriminatorType.STRING)
public class ReinsuranceTreaty extends AbstractEntity {

    @Column(name = "RI_TYPE",insertable = false,updatable = false)
    private ReinsuranceType riType;

    private Integer period;

    public ReinsuranceTreaty() {
    }

    public ReinsuranceType getRiType() {
        return riType;
    }

    public void setRiType(ReinsuranceType riType) {
        this.riType = riType;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }
}
