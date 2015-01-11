package ke.co.turbosoft.med.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by ktonym on 1/10/15.
 */
@Entity
public class PreAuth extends AbstractEntity {

    @Column(nullable = false)
    private LocalDate preAuthDate;
    @Column(nullable = false)
    private String preDiagnosis;
    @Column(nullable = false)
    private BigDecimal limit;
    @ManyToOne
    @Column(nullable = false)
    private Provider provider;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "member_id",referencedColumnName = "member_id",nullable = false),
            @JoinColumn(name = "benefit_id",referencedColumnName = "benefit_id",nullable = false)
    })
    private CorpMemberBenefit memberBenefit;
    private List<PreAuthBill> preAuthBills;


    public PreAuth() {
    }

    public LocalDate getPreAuthDate() {
        return preAuthDate;
    }

    public void setPreAuthDate(LocalDate preAuthDate) {
        this.preAuthDate = preAuthDate;
    }

    public String getPreDiagnosis() {
        return preDiagnosis;
    }

    public void setPreDiagnosis(String preDiagnosis) {
        this.preDiagnosis = preDiagnosis;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public CorpMemberBenefit getMemberBenefit() {
        return memberBenefit;
    }

    public void setMemberBenefit(CorpMemberBenefit memberBenefit) {
        this.memberBenefit = memberBenefit;
    }
}
