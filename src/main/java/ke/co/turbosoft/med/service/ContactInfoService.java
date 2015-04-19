package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.ContactInfo;
import ke.co.turbosoft.med.vo.Result;

import java.util.List;

/**
 * Created by akipkoech on 4/18/15.
 */
public interface ContactInfoService {

    public Result<ContactInfo> store(
            Integer idContactInfo,
            Integer idCorporate,
            String firstName,
            String surname,
            String jobTitle,
            String email,
            String tel,
            String actionUsername);

    public Result<ContactInfo> remove(Integer idContactInfo, String actionUsername);

    public Result<List<ContactInfo>> findAll(Integer idCorporate, String actionUsername);

}
