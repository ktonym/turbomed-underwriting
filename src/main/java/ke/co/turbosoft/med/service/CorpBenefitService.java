package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.CorpBenefit;

import java.util.List;

/**
 * Created by akipkoech on 12/8/14.
 */
public interface CorpBenefitService {
    List<CorpBenefit> findAll();
    void suspend(CorpBenefit corpBenefit);
    CorpBenefit add(CorpBenefit corpBenefit);
    void remove(CorpBenefit corpBenefit);
}
