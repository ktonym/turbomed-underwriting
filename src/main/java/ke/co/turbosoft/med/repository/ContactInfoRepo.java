package ke.co.turbosoft.med.repository;

import ke.co.turbosoft.med.entity.ContactInfo;
import ke.co.turbosoft.med.entity.Corporate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by akipkoech on 12/8/14.
 */
public interface ContactInfoRepo extends JpaRepository<ContactInfo,Integer> {

    List<ContactInfo> findByCorporate(Corporate corporate);
    ContactInfo findByEmail(String email);

}
