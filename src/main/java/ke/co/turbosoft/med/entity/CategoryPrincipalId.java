package ke.co.turbosoft.med.entity;

import java.io.Serializable;

/**
 * Created by ktonym on 1/2/15.
 */
public class CategoryPrincipalId implements Serializable{

    Category category;
    Principal principal;

    public CategoryPrincipalId() {
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
