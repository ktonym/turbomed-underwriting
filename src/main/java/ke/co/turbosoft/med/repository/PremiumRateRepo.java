package ke.co.turbosoft.med.repository;

import ke.co.turbosoft.med.entity.Corporate;
import ke.co.turbosoft.med.entity.PremiumRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by akipkoech on 12/9/14.
 */
public interface PremiumRateRepo extends JpaRepository<PremiumRate,Integer> {

    List<PremiumRate> findByCorpBenefit_Category_Anniv_Corporate(Corporate corporate);

}
