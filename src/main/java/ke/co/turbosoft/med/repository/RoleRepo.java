package ke.co.turbosoft.med.repository;

import ke.co.turbosoft.med.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by akipkoech on 12/8/14.
 */
public interface RoleRepo extends JpaRepository<Role,String> {
    Role findByRoleName(String roleName);
}
