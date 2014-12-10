package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.CorpAnniv;
import ke.co.turbosoft.med.entity.Corporate;
import ke.co.turbosoft.med.entity.Principal;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by akipkoech on 12/8/14.
 */
public interface CorporateService {

    Page<Corporate> getCorporates(Integer pageNumber);
    List<Corporate> findAll();
    Corporate search(Integer corpId);
    void renew(Corporate corporate);
    List<Corporate> listActive();
    List<Corporate> listInactive();
    List<Principal> listPrincipals(Corporate corporate);
    List<CorpAnniv> listAnniversaries(Corporate corporate);
}
