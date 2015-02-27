package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.*;
import ke.co.turbosoft.med.vo.Result;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by akipkoech on 12/8/14.
 */
public interface CorporateService {

    Result<List<Corporate>> findAll();
    Result<Corporate> search(Integer idCorp);
    void renew(Corporate corporate);
    Result<List<Corporate>> listActive();
    Result<List<Corporate>> listInactive();
    Result<List<Corporate>> listJoinedAfter(LocalDate localDate);
    Result<List<Corporate>> listJoinedBefore(LocalDate localDate);
    Result<List<Principal>> listPrincipals(Corporate corporate);
    Result<List<CorpAnniv>> listAnniversaries(Corporate corporate);
    Result<List<Member>> listMembers(Corporate corporate);
    Result<List<Member>> listActiveMembers(Corporate corporate);
    Result<List<Category>> listCategories(Corporate corporate);
    void save(Corporate corporate);
}
