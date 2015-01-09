package ke.co.turbosoft.med.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category extends AbstractEntity{

	private char cat;
	private String description;
	@OneToMany(mappedBy = "category")
	private List<CorpBenefit> corpBenefits;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "anniv_id")
    private CorpAnniv anniv;
    @OneToMany(mappedBy = "category")
    private List<CategoryPrincipal> categoryPrincipal;

    public Category() {
    }

    public char getCat() {
        return cat;
    }

    public void setCat(char cat) {
        this.cat = cat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CorpBenefit> getCorpBenefits() {
        return corpBenefits;
    }

    public void setCorpBenefits(List<CorpBenefit> corpBenefits) {
        this.corpBenefits = corpBenefits;
    }

    public CorpAnniv getAnniv() {
        return anniv;
    }

    public void setAnniv(CorpAnniv anniv) {
        this.anniv = anniv;
    }
}
