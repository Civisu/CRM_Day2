package customer.service.impl;

import customer.dao.CustomerDao;
import customer.domain.Customer;
import customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "customerService")
//@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    //查询所有客户
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    //保存客户
    public void save(Customer model) {
        //调用持久层保存客户
        customerDao.save(model);
    }

    //根据id查询客户
    public Customer findById(Long custId) {
        return customerDao.findById(custId);
    }

    //修改客户
    public void update(Customer model) {
        customerDao.update(model);
    }

    //删除客户
    public void delete(Customer model) {
        customerDao.delete(model);
    }
}
