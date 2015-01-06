package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.*;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
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
    List<Corporate> listJoinedAfter(LocalDate localDate);
    List<Corporate> listJoinedBefore(LocalDate localDate);
    List<Principal> listPrincipals(Corporate corporate);
    List<CorpAnniv> listAnniversaries(Corporate corporate);
    List<Member> listMembers(Corporate corporate);
    List<Member> listActiveMembers(Corporate corporate);
    List<Category> listCategories(Corporate corporate);
    void save(Corporate corporate);
}
