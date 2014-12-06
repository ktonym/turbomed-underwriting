package ke.co.turbosoft.med.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import ke.co.turbosoft.med.entity.CorpBenefit;
import java.util.Collection;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Integer id;
	
	private char cat;
	
	private String description;

	@OneToMany
	private Collection<CorpBenefit> corpBenefit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Collection<CorpBenefit> getCorpBenefit() {
	    return corpBenefit;
	}

	public void setCorpBenefit(Collection<CorpBenefit> param) {
	    this.corpBenefit = param;
	}
}
