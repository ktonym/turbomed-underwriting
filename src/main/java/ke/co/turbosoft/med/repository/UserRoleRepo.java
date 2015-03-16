package ke.co.turbosoft.med.repository;

import ke.co.turbosoft.med.entity.User;
import ke.co.turbosoft.med.entity.UserRole;
import ke.co.turbosoft.med.entity.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by akipkoech on 3/6/15.
 */
public interface UserRoleRepo extends JpaRepository<UserRole, UserRoleId> {

    List<UserRole> findByUser(User user);

    long countByUser(User user);

}
