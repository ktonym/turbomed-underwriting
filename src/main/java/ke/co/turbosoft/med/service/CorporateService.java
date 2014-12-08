package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.Corporate;

import java.util.List;

/**
 * Created by akipkoech on 12/8/14.
 */
public interface CorporateService {
    List<Corporate> findAll();
    Corporate search(Integer corpId);
    void renew(Corporate corporate);
}
