package ke.co.turbosoft.med.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by akipkoech on 12/9/14.
 */
@Entity
@DiscriminatorValue("XOL")
public class XOL extends ReinsuranceTreaty {

    public XOL() {
    }
}
