package ke.co.turbosoft.med.repository;

import ke.co.turbosoft.med.entity.CorpAnniv;
import ke.co.turbosoft.med.entity.Corporate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by akipkoech on 12/8/14.
 */
public interface CorpAnnivRepo extends JpaRepository<CorpAnniv,Integer> {
	//@Query("select a from CorpAnniv a where a.corporate = :corporate")
	//List<CorpAnniv> findByCorporate(@Param("corporate") Corporate corporate);

    List<CorpAnniv> findByCorporate(Corporate corporate);

    CorpAnniv findByCorporateAndAnniv(Corporate corporate, Integer anniv);
}
