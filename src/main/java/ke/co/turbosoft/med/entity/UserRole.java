package ke.co.turbosoft.med.entity;

import javax.json.JsonObjectBuilder;
import javax.persistence.*;

/**
 * Created by akipkoech on 12/8/14.
 */
@Entity //@IdClass(UserRoleId.class)
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"username","roleName"})})
public class UserRole extends AbstractEntity implements EntityItem<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUserRole;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="username")
    private User user;

    @Column(name="roleName")
    private RoleType role;

    public UserRole() {
    }

    public Integer getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(Integer idUserRole) {
        this.idUserRole = idUserRole;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    @Override
    public void addJson(JsonObjectBuilder builder) {
        builder.add("idUserRole",idUserRole)
               .add("role", role.toString());
        user.addJson(builder);
//        role.addJson(builder);

    }

    @Override
    public Integer getId() {
        return idUserRole;
    }
}
