package ke.co.turbosoft.med.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class CorpAnniv extends AbstractEntity {

	private Integer anniv;
	@Convert(converter=LocalDatePersistenceConverter.class)
	private LocalDate startDate;
	@Convert(converter=LocalDatePersistenceConverter.class)
	private LocalDate endDate;
    @Convert(converter=LocalDatePersistenceConverter.class)
    private LocalDate renewalDate;
	@OneToMany(mappedBy = "anniv")
	private List<Category> category;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="corp_id")
    private Corporate corporate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "intermediary_id")
    private Intermediary intermediary;

    public CorpAnniv() {
    }

    public Integer getAnniv() {
        return anniv;
    }

    public void setAnniv(Integer anniv) {
        this.anniv = anniv;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(LocalDate renewalDate) {
        this.renewalDate = renewalDate;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public Corporate getCorporate() {
        return corporate;
    }

    public void setCorporate(Corporate corporate) {
        this.corporate = corporate;
    }

    public Intermediary getIntermediary() {
        return intermediary;
    }

    public void setIntermediary(Intermediary intermediary) {
        this.intermediary = intermediary;
    }
}
