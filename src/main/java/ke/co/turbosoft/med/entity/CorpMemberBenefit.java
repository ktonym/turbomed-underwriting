package ke.co.turbosoft.med.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * Created by akipkoech on 12/8/14.
 */
@Entity
public class CorpMemberBenefit extends AbstractEntity{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="member_id")
    private Member member;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="benefit_id")
    private CorpBenefit benefit;
    private BenefitStatus status;
    private LocalDate wef;

    public CorpMemberBenefit() {
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public CorpBenefit getBenefit() {
        return benefit;
    }

    public void setBenefit(CorpBenefit benefit) {
        this.benefit = benefit;
    }

    public BenefitStatus getStatus() {
        return status;
    }

    public void setStatus(BenefitStatus status) {
        this.status = status;
    }

    public LocalDate getWef() {
        return wef;
    }

    public void setWef(LocalDate wef) {
        this.wef = wef;
    }
}
