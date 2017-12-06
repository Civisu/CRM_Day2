package customer.dao.impl;

import customer.dao.CustomerDao;
import customer.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "customerDao")
public class CustomerDaoImpl implements CustomerDao {

    //使用HibernateTemplate模板类，Spring提供，封装了Session对象
    @Autowired
    private HibernateTemplate hibernateTemplate;

    //查询所有客户
    public List<Customer> findAll() {
        return (List<Customer>) hibernateTemplate.find("from Customer");
    }

    //保存客户
    public void save(Customer model) {
        hibernateTemplate.save(model);
    }

    //根据id查询客户
    public Customer findById(Long custId) {
        return hibernateTemplate.get(Customer.class, custId);
    }

    //修改客户
    public void update(Customer model) {
        hibernateTemplate.update(model);
    }

    //删除客户
    public void delete(Customer model) {
        hibernateTemplate.delete(model);
    }
}
