package dict.service.impl;

import dict.dao.DictDao;
import dict.domain.Dict;
import dict.service.DictService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//字典业务层
@Service(value = "dictService")
public class DictServiceImpl implements DictService {
    @Autowired
    private DictDao dictDao;

    //查询
    public List<Dict> findByWhere(DetachedCriteria criteria) {
        return dictDao.findByWhere(criteria);
    }
}
