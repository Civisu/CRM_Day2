package linkman.dao.impl;

import linkman.dao.LinkmanDao;
import linkman.domain.Linkman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LinkmanDaoImpl implements LinkmanDao {
    //注入HibernateTemplate
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void add(Linkman linkman) {
        hibernateTemplate.save(linkman);
    }
}
