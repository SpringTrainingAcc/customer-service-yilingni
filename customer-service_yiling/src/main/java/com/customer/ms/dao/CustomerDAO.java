package com.customer.ms.dao;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.customer.ms.model.Customer;

@Repository
public class CustomerDAO {

	private static final Map<String, Customer> cusMap = new HashMap<String, Customer>();
	
	static {
		initCus();
	}
	
	private static void initCus() {
		Customer cus1 = new Customer("C01", "Smith", "NY");
		Customer cus2 = new Customer("C02", "Smith", "NY");
		Customer cus3 = new Customer("C03", "Smith", "NY");
		
		cusMap.put(cus1.getCusId(), cus1);
		cusMap.put(cus1.getCusId(), cus2);
		cusMap.put(cus1.getCusId(), cus3);
	}
	
	public Customer getCustomer(String cusId) {
		return cusMap.get(cusId);
	}
	
	public List<Customer> getAllCustomers(){
		Collection<Customer> c = cusMap.values();
		List<Customer> list = new ArrayList<Customer>();
		list.addAll(c);
		return list;
	}
	
	public Customer addCustomer(Customer cus) {
		cusMap.put(cus.getCusId(), cus);
		
		return cus;
	}
	
	public Customer updateCustomer(Customer cus, String name, String address) {
		cusMap.remove(cus.getCusId(), cus);
		
		cus.setAddress(address);
		cus.setCusName(name);
		
		cusMap.put(cus.getCusId(), cus);
		
		return cus;
	}
	
	public String deleteCustomer(Customer cus) {
		cusMap.remove(cus.getCusId(), cus);
		
		return "Customer " + cus.getCusId() + "has been deleted.";
	}
}
