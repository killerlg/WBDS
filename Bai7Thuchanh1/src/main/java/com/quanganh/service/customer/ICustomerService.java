package com.quanganh.service.customer;

import com.quanganh.model.Customer;
import com.quanganh.model.Province;
import com.quanganh.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
