package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.CorpAnniv;
import ke.co.turbosoft.med.entity.Corporate;
import ke.co.turbosoft.med.entity.Principal;
import ke.co.turbosoft.med.repository.CorporateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by akipkoech on 12/10/14.
 */
@Service
@Transactional
public class CorporateServiceImpl implements CorporateService {

    private static final int PAGE_SIZE = 2;

    @Autowired
    private CorporateRepo corporateRepo;

    @Override
    public Page<Corporate> getCorporates(Integer pageNumber) {
        PageRequest request =new PageRequest(pageNumber - 1, PAGE_SIZE );
                //new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "abbreviation" );
        return corporateRepo.findAll(request);
    }

    @Override
    public List<Corporate> findAll() {
        return corporateRepo.findAll();
    }

    @Override
    public Corporate search(Integer corpId) {
        return corporateRepo.findOne(corpId);
    }

    @Override
    public void renew(Corporate corporate) {

    }

    @Override
    public List<Corporate> listActive() {
        return null;
    }

    @Override
    public List<Corporate> listInactive() {
        return null;
    }

    @Override
    public List<Principal> listPrincipals(Corporate corporate) {
        return null;
    }

    @Override
    public List<CorpAnniv> listAnniversaries(Corporate corporate) {
        return null;
    }
}
