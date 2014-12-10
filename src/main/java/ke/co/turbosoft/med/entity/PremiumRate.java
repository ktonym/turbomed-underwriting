package ke.co.turbosoft.med.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by akipkoech on 12/9/14.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PREMIUM_TYPE",discriminatorType = DiscriminatorType.STRING)
public class PremiumRate extends AbstractEntity{

    @Column(name = "PREMIUM_TYPE",insertable = false,updatable = false)
    private PremiumType type;
    private String benefit;
    private BigDecimal upperLimit;
    private BigDecimal premium;
    private String familySize;

    public PremiumRate() {
    }

    public PremiumType getType() {
        return type;
    }

    public void setType(PremiumType type) {
        this.type = type;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public BigDecimal getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(BigDecimal upperLimit) {
        this.upperLimit = upperLimit;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public String getFamilySize() {
        return familySize;
    }

    public void setFamilySize(String familySize) {
        this.familySize = familySize;
    }
}
