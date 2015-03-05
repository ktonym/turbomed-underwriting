package ke.co.turbosoft.med.entity;

import javax.json.JsonObjectBuilder;
import javax.persistence.*;
import java.util.List;

/**
 * Created by akipkoech on 12/8/14.
 */
@Entity
public class Regulation extends AbstractEntity implements EntityItem<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idRegulation;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "anniv_id",unique = true)
    private CorpAnniv anniv;
    private Integer commRate;
    private Integer whTaxRate;
    private Boolean coPay;
    @OneToMany(mappedBy = "regulation")
    private List<CoPay> coPayList;

    public Regulation() {
    }

    public Integer getIdRegulation() {
        return idRegulation;
    }

    public void setIdRegulation(Integer idRegulation) {
        this.idRegulation = idRegulation;
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

    @Override
    public void addJson(JsonObjectBuilder builder) {
        builder.add("idRegulation",idRegulation)
                .add("commRate", commRate)
                .add("whTaxRate",whTaxRate)
                .add("coPay",coPay);
        anniv.addJson(builder);
    }

    @Override
    public Integer getId() {
        return idRegulation;
    }
}
