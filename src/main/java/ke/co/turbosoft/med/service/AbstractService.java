package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.User;
import ke.co.turbosoft.med.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by akipkoech on 3/5/15.
 */
public class AbstractService {

    final protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected UserRepo userRepo;

    protected final String USER_INVALID = "Not a valid user";
    protected final String USER_NOT_AUTHORIZED = "Transaction not authorized";

    protected boolean isValidUser(String username){
        User user = userRepo.findOne(username);
        return user != null;
    }

}
