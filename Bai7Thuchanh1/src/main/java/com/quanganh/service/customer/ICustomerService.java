package com.quanganh.service.customer;

import com.quanganh.model.Customer;
import com.quanganh.model.Province;
import com.quanganh.service.IGeneralService;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
