package ke.co.turbosoft.med.entity;

import javax.json.JsonObjectBuilder;
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

    @Override
    public void addJson(JsonObjectBuilder builder) {

        super.addJson(builder);

        //
        //Can't believe I was this silly!!
        //
        //        builder.add("idPremiumRate", idPremiumRate)
        //                .add("premiumType", premiumType.toString())
        //                .add("benefit", benefit)
        //                .add("upperLimit", upperLimit)
        //                .add("premium", premium)
        //                .add("familySize", familySize);
        corporate.addJson(builder);


    }

}
