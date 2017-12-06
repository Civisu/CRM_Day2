package dict.dao.impl;

import dict.dao.DictDao;
import dict.domain.Dict;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//字典持久层
@Repository(value = "dictDao")
public class DictDaoImpl implements DictDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    //离线查询
    public List<Dict> findByWhere(DetachedCriteria criteria) {
        return (List<Dict>) hibernateTemplate.findByCriteria(criteria);
    }
}
