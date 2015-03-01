package ke.co.turbosoft.med.entity;

import org.hibernate.metamodel.domain.Superclass;

import javax.json.JsonObjectBuilder;
import javax.persistence.*;

/**
 * Created by akipkoech on 12/8/14.
 */
@Entity
@DiscriminatorValue("AGENCY")
public class Agency extends Intermediary {

    private String name;
    private String street;
    private String town;
    private String postalAddress;

    public Agency() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    @Override
    public void addJson(JsonObjectBuilder builder) {

        super.addJson(builder);

        builder.add("name", name)
                .add("street",street)
                .add("town",town)
                .add("postalAddress", postalAddress);
    }

}
