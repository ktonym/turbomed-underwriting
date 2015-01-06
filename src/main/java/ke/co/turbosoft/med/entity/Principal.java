package ke.co.turbosoft.med.entity;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by akipkoech on 12/8/14.
 */
@Entity
public class Principal extends AbstractEntity {

    private String familyNo;
    private String firstName;
    private String surname;
    private String otherNames;
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate dob;
    @OneToMany(mappedBy = "principal")
    private List<Member> dependants;
    @OneToMany(mappedBy = "principal")
    private List<CategoryPrincipal> categoryPrincipal;

    public Principal() {
    }

    public String getFamilyNo() {
        return familyNo;
    }

    public void setFamilyNo(String familyNo) {
        this.familyNo = familyNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<Member> getDependants() {
        return dependants;
    }

    public void setDependants(List<Member> dependants) {
        this.dependants = dependants;
    }
}
