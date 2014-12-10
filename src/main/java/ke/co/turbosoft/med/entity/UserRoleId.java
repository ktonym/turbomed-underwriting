package ke.co.turbosoft.med.entity;

import java.io.Serializable;

/**
 * Created by akipkoech on 12/8/14.
 */
public class UserRoleId implements Serializable {
    User user;
    Role role;

    public UserRoleId() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
