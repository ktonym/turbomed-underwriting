package ke.co.turbosoft.med.repository;

import ke.co.turbosoft.med.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by akipkoech on 12/8/14.
 */
public interface UserRepo extends JpaRepository<User,String> {
    User findByUsernameAndPassword(String username,String password);
    User findByEmail(String email);
}
