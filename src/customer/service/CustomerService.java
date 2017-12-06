package customer.service;

import customer.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer model);

    Customer findById(Long custId);

    void update(Customer model);

    void delete(Customer model);
}
