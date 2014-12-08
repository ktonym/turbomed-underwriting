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

}
