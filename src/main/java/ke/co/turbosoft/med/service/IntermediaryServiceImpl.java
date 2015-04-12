package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.Broker;
import ke.co.turbosoft.med.entity.Intermediary;
import ke.co.turbosoft.med.entity.IntermediaryType;
import ke.co.turbosoft.med.repository.IntermediaryRepo;
import ke.co.turbosoft.med.vo.Result;
import ke.co.turbosoft.med.vo.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by ktonym on 4/12/15.
 */
@Service("intermediaryService")
@Transactional
public class IntermediaryServiceImpl extends AbstractService implements IntermediaryService {

    @Autowired
    private IntermediaryRepo intermediaryRepo;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Result<List<Intermediary>> findAll(String actionUsername) {

        if(!isValidUser(actionUsername))
            return ResultFactory.getFailResult(USER_INVALID);

        List<Intermediary> intermediaries = intermediaryRepo.findAll();

        return ResultFactory.getSuccessResult(intermediaries);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Result<Intermediary> find(Integer idIntermediary, String actionUsername) {
        return null;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Result<Intermediary> remove(Integer idIntermediary, String actionUsername) {
        return null;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Result<Broker> addBroker(String PIN, IntermediaryType type, LocalDate joinDate, String email, String tel, String name, String street, String town, String postalAddress, String actionUsername) {
        return null;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Result<Broker> addAgency(String PIN, IntermediaryType type, LocalDate joinDate, String email, String tel, String name, String street, String town, String postalAddress, String actionUsername) {
        return null;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Result<Broker> addAgent(String PIN, IntermediaryType type, LocalDate joinDate, String email, String tel, String firstName, String surname, String otherNames, String actionUsername) {
        return null;
    }
}
