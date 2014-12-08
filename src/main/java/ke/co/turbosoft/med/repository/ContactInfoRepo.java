package ke.co.turbosoft.med.repository;

import ke.co.turbosoft.med.entity.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by akipkoech on 12/8/14.
 */
public interface ContactInfoRepo extends JpaRepository<ContactInfo,Integer> {
}
