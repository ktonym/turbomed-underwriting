package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.CorpAnniv;
import ke.co.turbosoft.med.entity.Corporate;
import ke.co.turbosoft.med.vo.Result;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by akipkoech on 4/6/15.
 */
public interface CorpAnnivService {

    Result<CorpAnniv> store(
            Integer idCorporate,
            Integer idCorpAnniv,
            Integer idIntermediary,
            Integer anniv,
            LocalDate startDate,
            LocalDate endDate,
            LocalDate renewalDate,
            String actionUsername
    );

    Result<CorpAnniv> remove(Integer idCorpAnniv, String actionUsername);

    Result<CorpAnniv> find(Integer idCorpAnniv, String actionUsername);

    Result<List<CorpAnniv>> findAll(String actionUsername);

    Result<List<CorpAnniv>> findByCorporate(Corporate corporate, String actionUsername);


}
