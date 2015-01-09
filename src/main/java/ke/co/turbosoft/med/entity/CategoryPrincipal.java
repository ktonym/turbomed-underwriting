package ke.co.turbosoft.med.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by ktonym on 1/2/15.
 */
@Entity @IdClass(CategoryPrincipalId.class)
public class CategoryPrincipal{

    private Boolean active;
    private LocalDate wef;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "principal_id")
    private Principal principal;

    public CategoryPrincipal() {
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getWef() {
        return wef;
    }

    public void setWef(LocalDate wef) {
        this.wef = wef;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
}
