package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.User;
import ke.co.turbosoft.med.entity.UserRole;
import ke.co.turbosoft.med.repository.UserRepo;
import ke.co.turbosoft.med.repository.UserRoleRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by akipkoech on 3/5/15.
 */
public abstract class AbstractService {

    final protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected UserRepo userRepo;

    @Autowired
    protected UserRoleRepo userRoleRepo;

    protected final String USER_INVALID = "Not a valid user";
    protected final String USER_NOT_AUTHORIZED = "Transaction not authorized";

    protected boolean isValidUser(String username){
        User user = userRepo.findOne(username);
        return user != null;
    }

    protected boolean hasRole(String username, String roleName){

        Predicate<UserRole> predicate = p -> p.getRole().getRoleName().equals(roleName);

        return getRoles(username).stream().anyMatch(predicate);
    }

    protected List<UserRole> getRoles(String username){

        User user = userRepo.findOne(username);

        return userRoleRepo.findByUser(user);
    }

}
