package ke.co.turbosoft.med.entity;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import ke.co.turbosoft.med.entity.CorpBenefit;
import java.util.Collection;

/**
 * Entity implementation class for Entity: CorpBenefit
 *
 */
@Entity

public class CorpBenefit implements Serializable {

	   
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Double upperLimit;
	private String memberType;
	private boolean sharing;
	private static final long serialVersionUID = 1L;
	@ManyToMany
	private Collection<CorpBenefit> corpBenefit;
	@ManyToMany(mappedBy = "corpBenefit")
	private Collection<CorpBenefit> corpBenefit_1;

	public CorpBenefit() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Double getUpperLimit() {
		return this.upperLimit;
	}

	public void setUpperLimit(Double upperLimit) {
		this.upperLimit = upperLimit;
	}   
	public String getMemberType() {
		return this.memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}   
	public boolean getSharing() {
		return this.sharing;
	}

	public void setSharing(boolean sharing) {
		this.sharing = sharing;
	}
	public Collection<CorpBenefit> getCorpBenefit() {
	    return corpBenefit;
	}
	public void setCorpBenefit(Collection<CorpBenefit> param) {
	    this.corpBenefit = param;
	}
	public Collection<CorpBenefit> getCorpBenefit_1() {
	    return corpBenefit_1;
	}
	public void setCorpBenefit_1(Collection<CorpBenefit> param) {
	    this.corpBenefit_1 = param;
	}
   
}
