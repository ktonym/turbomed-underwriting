package ke.co.turbosoft.med.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by akipkoech on 12/8/14.
 */
@Entity
public class Regulation extends AbstractEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "anniv_id",unique = true)
    private CorpAnniv anniv;
    private Integer commRate;
    private Integer whTaxRate;
    private Boolean coPay;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CoPay> coPayList;

    public Regulation() {
    }

    public CorpAnniv getAnniv() {
        return anniv;
    }

    public void setAnniv(CorpAnniv anniv) {
        this.anniv = anniv;
    }

    public Integer getCommRate() {
        return commRate;
    }

    public void setCommRate(Integer commRate) {
        this.commRate = commRate;
    }

    public Integer getWhTaxRate() {
        return whTaxRate;
    }

    public void setWhTaxRate(Integer whTaxRate) {
        this.whTaxRate = whTaxRate;
    }

    public Boolean getCoPay() {
        return coPay;
    }

    public void setCoPay(Boolean coPay) {
        this.coPay = coPay;
    }

    public List<CoPay> getCoPayList() {
        return coPayList;
    }

    public void setCoPayList(List<CoPay> coPayList) {
        this.coPayList = coPayList;
    }
}
