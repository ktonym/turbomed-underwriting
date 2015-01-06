package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.*;
import ke.co.turbosoft.med.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
    private CorpAnnivRepo corpAnnivRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private PrincipalRepo principalRepo;

    @Autowired
    private MemberRepo memberRepo;

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
        //return principalRepo.findByCategoryPrincipal_Category_Anniv_Corporate(corporate);
        return null;
    }

    @Override
    @Transactional(readOnly=true)
    public List<CorpAnniv> listAnniversaries(Corporate corporate) {
        return corpAnnivRepo.findByCorporate(corporate);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Member> listMembers(Corporate corporate) {
        return memberRepo.findByPrincipal_CategoryPrincipal_Category_Anniv_Corporate(corporate);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Member> listActiveMembers(Corporate corporate) {
        return null;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Category> listCategories(Corporate corporate) {
        return categoryRepo.findByAnniv_Corporate(corporate);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Corporate> listJoinedAfter(LocalDate localDate) {
        return corporateRepo.findByJoinedAfter(localDate);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Corporate> listJoinedBefore(LocalDate localDate) {
        return corporateRepo.findByJoinedBefore(localDate);
    }

    @Override
    @Transactional
    public void save(Corporate corporate) {
        corporateRepo.save(corporate);
    }
}
