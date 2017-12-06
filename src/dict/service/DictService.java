package dict.service;

import dict.domain.Dict;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface DictService {
    List<Dict> findByWhere(DetachedCriteria criteria);
}
