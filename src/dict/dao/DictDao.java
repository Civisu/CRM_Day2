package dict.dao;

import dict.domain.Dict;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface DictDao {
    List<Dict> findByWhere(DetachedCriteria criteria);
}
