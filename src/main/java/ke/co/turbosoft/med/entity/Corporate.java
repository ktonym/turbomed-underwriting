package ke.co.turbosoft.med.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import ke.co.turbosoft.med.entity.CorpAnniv;
import java.util.Collection;
import javax.persistence.OneToMany;

@Entity
public class Corporate {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private String abbreviation;
	private String tel;
	private String email;

	@OneToMany
	private Collection<CorpAnniv> corpAnniv;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Collection<CorpAnniv> getCorpAnniv() {
	    return corpAnniv;
	}
	public void setCorpAnniv(Collection<CorpAnniv> param) {
	    this.corpAnniv = param;
	}
	

}
