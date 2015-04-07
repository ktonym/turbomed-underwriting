package ke.co.turbosoft.med.repository;

import ke.co.turbosoft.med.entity.Category;
import ke.co.turbosoft.med.entity.CorpAnniv;
import ke.co.turbosoft.med.entity.Corporate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by akipkoech on 12/8/14.
 */
public interface CategoryRepo extends JpaRepository<Category,Integer> {
    List<Category> findByAnniv_Corporate(Corporate corporate);
    List<Category> findByAnniv(CorpAnniv anniv);
    long countByAnniv(CorpAnniv anniv);
}
