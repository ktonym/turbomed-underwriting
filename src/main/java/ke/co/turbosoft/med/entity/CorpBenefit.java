package ke.co.turbosoft.med.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Entity implementation class for Entity: CorpBenefit
 *
 */
@Entity

public class CorpBenefit extends AbstractEntity {

	private String name;
	private Double upperLimit;
	private String memberType;
	private boolean sharing;
    private Integer waitingPeriod;
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="parentBenefit_id",nullable = true)
	private CorpBenefit parentBenefit;
	@OneToMany(mappedBy = "parentBenefit")
	private List<CorpBenefit> subBenefit;
    @OneToMany(mappedBy = "benefit")
    private List<CorpMemberBenefit> corpMemberBenefits;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    //TODO consider adding Boolean requiresPreAuthorization


    public CorpBenefit() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Double upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public boolean isSharing() {
        return sharing;
    }

    public void setSharing(boolean sharing) {
        this.sharing = sharing;
    }

    public Integer getWaitingPeriod() {
        return waitingPeriod;
    }

    public void setWaitingPeriod(Integer waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }

    public CorpBenefit getParentBenefit() {
        return parentBenefit;
    }

    public void setParentBenefit(CorpBenefit parentBenefit) {
        this.parentBenefit = parentBenefit;
    }

    public List<CorpBenefit> getSubBenefit() {
        return subBenefit;
    }

    public void setSubBenefit(List<CorpBenefit> subBenefit) {
        this.subBenefit = subBenefit;
    }

    public List<CorpMemberBenefit> getCorpMemberBenefits() {
        return corpMemberBenefits;
    }

    public void setCorpMemberBenefits(List<CorpMemberBenefit> corpMemberBenefits) {
        this.corpMemberBenefits = corpMemberBenefits;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isMainBenefit(){
        return (this.getParentBenefit() == null);
    }

}
