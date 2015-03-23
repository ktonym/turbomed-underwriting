package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.*;
import ke.co.turbosoft.med.vo.Result;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by akipkoech on 12/8/14.
 */
public interface CorporateService {

//    Consider returning a Result<Page<Corporate>> object;
//    Page<Corporate> getCorporates(Integer pageNumber);

/*
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
*/

    Result<Corporate> store(
            Integer idCorporate,
            String corporateName,
            String abbreviation,
            String tel,
            String email,
            String postalAddress,
            LocalDate joined,
            String actionUsername
    );

    Result<Corporate> remove(Integer idCorporate, String actionUsername);

    Result<Corporate> find(Integer idCorporate, String actionUsername);

    Result<List<Corporate>> findAll(String actionUsername);
}
