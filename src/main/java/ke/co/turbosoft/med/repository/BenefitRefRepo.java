package ke.co.turbosoft.med.repository;

import ke.co.turbosoft.med.entity.BenefitRef;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by akipkoech on 25/05/15.
 */
public interface BenefitRefRepo extends JpaRepository<BenefitRef, Integer> {
    BenefitRef findByBenefitName(String benefitName);
}
