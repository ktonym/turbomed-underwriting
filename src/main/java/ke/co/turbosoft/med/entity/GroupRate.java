package ke.co.turbosoft.med.entity;

import javax.persistence.*;

/**
 * Created by akipkoech on 12/9/14.
 */
@Entity
@DiscriminatorValue("GROUP")
public class GroupRate extends PremiumRate {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "corp_id")
    private Corporate corporate;

    public GroupRate() {
    }

    public Corporate getCorporate() {
        return corporate;
    }

    public void setCorporate(Corporate corporate) {
        this.corporate = corporate;
    }
}
