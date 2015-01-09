package ke.co.turbosoft.med.entity;

import java.io.Serializable;

/**
 * Created by ktonym on 1/9/15.
 */
public class CorpMemberBenefitId implements Serializable{

    CorpBenefit corpBenefit;
    Member member;

    public CorpMemberBenefitId() {
    }

    public CorpBenefit getCorpBenefit() {
        return corpBenefit;
    }

    public void setCorpBenefit(CorpBenefit corpBenefit) {
        this.corpBenefit = corpBenefit;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
