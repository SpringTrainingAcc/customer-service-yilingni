package com.customer.ms.service;

import java.util.List;

import com.customer.ms.model.CustomerM;

public interface CustomerService {

	List<CustomerM> findAll();
	
	CustomerM addCustomer(CustomerM customerm);

	CustomerM findById(String cusId);
}
