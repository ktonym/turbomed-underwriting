package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.CorpAnniv;
import ke.co.turbosoft.med.entity.Corporate;
import ke.co.turbosoft.med.entity.Principal;
import ke.co.turbosoft.med.repository.CorpAnnivRepo;
import ke.co.turbosoft.med.repository.CorporateRepo;
import ke.co.turbosoft.med.repository.PrincipalRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by akipkoech on 12/10/14.
 */
@Service

public class CorporateServiceImpl implements CorporateService {

    private static final int PAGE_SIZE = 3;

    @Autowired
    private CorporateRepo corporateRepo;
    
    @Autowired
    private PrincipalRepo principalRepo;
    
    @Autowired
    private CorpAnnivRepo corpAnnivRepo;

    @Override
    @Transactional(readOnly=true)
    public Page<Corporate> getCorporates(Integer pageNumber) {
        PageRequest request =new PageRequest(pageNumber - 1, PAGE_SIZE,Sort.Direction.ASC, "abbreviation" );
        return corporateRepo.findAll(request);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Corporate> findAll() {
        return corporateRepo.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Corporate search(Integer corpId) {
        return corporateRepo.findOne(corpId);
    }

    @Override
    @Transactional
    public void renew(Corporate corporate) {

    }

    @Override
    @Transactional(readOnly=true)
    public List<Corporate> listActive() {
        return null;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Corporate> listInactive() {
        return null;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Principal> listPrincipals(Corporate corporate) {
        //return principalRepo.findByCorporate(corporate);
    	return null;
    }

    @Override
    @Transactional(readOnly=true)
    public List<CorpAnniv> listAnniversaries(Corporate corporate) {
        return corpAnnivRepo.findByCorporate(corporate);
    }
}
