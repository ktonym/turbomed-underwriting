package ke.co.turbosoft.med.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Corporate extends AbstractEntity {

	private String name;
	private String abbreviation;
	private String tel;
	private String email;
    private String postalAddress;
	@OneToMany(mappedBy = "corporate")
	private List<CorpAnniv> annivs;
    @OneToMany(mappedBy = "corporate")
    private List<ContactInfo> contactInfo;
    @Convert(converter=LocalDatePersistenceConverter.class)
    private LocalDate joined;
    @OneToMany(mappedBy = "corporate")
    private List<GroupRate> rates;

    public Corporate() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public List<CorpAnniv> getAnnivs() {
        return annivs;
    }

    public void setAnnivs(List<CorpAnniv> annivs) {
        this.annivs = annivs;
    }

    public List<ContactInfo> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(List<ContactInfo> contactInfo) {
        this.contactInfo = contactInfo;
    }

    public LocalDate getJoined() {
        return joined;
    }

    public void setJoined(LocalDate joined) {
        this.joined = joined;
    }

    public List<GroupRate> getRates() {
        return rates;
    }

    public void setRates(List<GroupRate> rates) {
        this.rates = rates;
    }
}
