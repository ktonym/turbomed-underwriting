package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.User;
import ke.co.turbosoft.med.vo.Result;
import ke.co.turbosoft.med.vo.ResultFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("userService")
public class UserServiceImpl extends AbstractService implements UserService {

    public UserServiceImpl() {
        super();
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Result<List<User>> findAll(String actionUsername) {

        if ( isValidUser(actionUsername)){

            return ResultFactory.getSuccessResult(userRepo.findAll());

        } else {

            return ResultFactory.getFailResult(USER_INVALID);

        }

    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Result<User> findByUsernameAndPassword(String username, String password) {

        User user = userRepo.findByUsernameAndPassword(username,password);

        if ( user == null ){
            return ResultFactory.getFailResult("Unable to verify username/password combination");
        } else {
            return ResultFactory.getSuccessResult(user);
        }

    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Result<User> store(String username, String email, String password, String firstName, String lastName, String actionUsername) {
        return null;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Result<User> remove(String username, String actionUsername) {
        return null;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Result<User> find(String username, String actionUsername) {
        return null;
    }
}
