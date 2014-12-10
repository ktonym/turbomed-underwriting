package ke.co.turbosoft.med.entity;

import javax.persistence.*;

/**
 * Created by akipkoech on 12/8/14.
 */
@Entity @IdClass(UserRoleId.class)
public class UserRole {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="role_id")
    private Role role;

    public UserRole() {
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
