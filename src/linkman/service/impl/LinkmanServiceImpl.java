package linkman.service.impl;

import linkman.dao.LinkmanDao;
import linkman.domain.Linkman;
import linkman.service.LinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "linkmanService")
public class LinkmanServiceImpl implements LinkmanService {
    //注入Dao
    @Autowired
    private LinkmanDao linkmanDao;
    //新增联系人
    public void add(Linkman linkman) {
        linkmanDao.add(linkman);
    }
}
