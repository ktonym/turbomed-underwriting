package ke.co.turbosoft.med.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by akipkoech on 12/8/14.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="INTERMEDIARY_TYPE",discriminatorType = DiscriminatorType.STRING)
//might need @ForceDiscriminator
public class Intermediary extends AbstractEntity {

    private String PIN;
    @Column(name = "INTERMEDIARY_TYPE",insertable = false,updatable = false)
    private IntermediaryType type;
    private LocalDate joinDate;
    private String email;
    private String tel;
    @OneToMany(mappedBy = "intermediary")
    private List<CorpAnniv> corpAnnivs;

    public Intermediary() {
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public IntermediaryType getType() {
        return type;
    }

    public void setType(IntermediaryType type) {
        this.type = type;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<CorpAnniv> getCorpAnnivs() {
        return corpAnnivs;
    }

    public void setCorpAnnivs(List<CorpAnniv> corpAnnivs) {
        this.corpAnnivs = corpAnnivs;
    }
}
