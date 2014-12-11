package ke.co.turbosoft.med.repository;

import java.util.List;

import ke.co.turbosoft.med.entity.Corporate;
import ke.co.turbosoft.med.entity.Principal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by akipkoech on 12/8/14.
 */
public interface PrincipalRepo extends JpaRepository<Principal,Integer> {
	//@Query("select p from Principal p where p.corporate = :corporate")
	//List<Principal> findByCorporate(@Param("corporate") Corporate corporate);
}
