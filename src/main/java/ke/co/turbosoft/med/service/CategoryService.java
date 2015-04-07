package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.Category;
import ke.co.turbosoft.med.entity.CorpAnniv;
import ke.co.turbosoft.med.vo.Result;

import java.util.List;

/**
 * Created by akipkoech on 4/7/15.
 */
public interface CategoryService {

    public Result<Category> store(
            Integer idCategory,
            Integer idCorpAnniv,
            char cat,
            String description,
            String actionUsername);

    public Result<Category> remove(Integer idCategory, String actionUsername);
    public Result<Category> find(Integer idCategory,String actionUsername);
    public Result<List<Category>> findAll(String actionUsername);
    public Result<List<Category>> findByAnniv(CorpAnniv anniv, String actionUsername);


}
