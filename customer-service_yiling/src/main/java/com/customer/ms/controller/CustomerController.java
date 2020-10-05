package com.customer.ms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.ms.dao.CustomerDAO;
import com.customer.ms.model.Customer;
import com.customer.ms.model.CustomerM;
import com.customer.ms.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Greetings from Spring Boot 1.0";
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Customer> getCustomers(){
		List<Customer> list = customerDAO.getAllCustomers();
		
		return list;
	}
	
	@RequestMapping(value = "/customers/{cusId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Customer getCustomers(@PathVariable("cusId") String cusId){
		return customerDAO.getCustomer(cusId);
		
	}
	
	@RequestMapping(value = "/customers/{cusId}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerDAO.addCustomer(customer);
	}
	
	@RequestMapping(value = "/customer/{cusId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
	public String deleteCustomer(@PathVariable Customer customer) {
		return customerDAO.deleteCustomer(customer);
	}
	
	@RequestMapping(value = "/customer/{cusId}", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Customer updateCustomer(@RequestBody Customer cus, @PathVariable String name, @PathVariable String address) {
		return customerDAO.updateCustomer(cus, name, address);
	}
	
	@RequestMapping(value = "/mongoCustomers", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<CustomerM> getMongoCustomers(){
		List<CustomerM> list = customerService.findAll();
		return list;
	}
	
	@RequestMapping(value = "/mongoCustomer/{cusId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public CustomerM getMongoCustomers(@PathVariable("cusId") String cusId){
		return customerService.findById(cusId);
	}
	
	@RequestMapping(value = "/mongoCustomer", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public CustomerM addMongoCustomers(@RequestBody CustomerM customerM){
		return customerService.addCustomer(customerM);
	}
}
