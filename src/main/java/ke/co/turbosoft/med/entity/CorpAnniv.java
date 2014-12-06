package ke.co.turbosoft.med.entity;

import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import ke.co.turbosoft.med.entity.Category;
import java.util.Collection;
import javax.persistence.OneToMany;

@Entity
public class CorpAnniv {
	
	@Id
	@GeneratedValue
	private String id;
	
	private Integer anniv;
	
	@Convert(converter=LocalDatePersistenceConverter.class)
	private LocalDate startDate;
	
	@Convert(converter=LocalDatePersistenceConverter.class)
	private LocalDate endDate;

	@OneToMany
	private Collection<Category> category;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Collection<Category> getCategory() {
	    return category;
	}
	public void setCategory(Collection<Category> param) {
	    this.category = param;
	}
	
	
}
