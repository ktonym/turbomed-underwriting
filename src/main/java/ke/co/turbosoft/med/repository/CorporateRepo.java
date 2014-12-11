package ke.co.turbosoft.med.repository;

import java.util.List;

import ke.co.turbosoft.med.entity.CorpAnniv;
import ke.co.turbosoft.med.entity.Corporate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by akipkoech on 12/8/14.
 */
public interface CorporateRepo extends JpaRepository<Corporate,Integer> {
	
}
