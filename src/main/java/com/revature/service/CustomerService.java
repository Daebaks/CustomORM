package com.revature.service;

import java.util.List;
import java.util.Optional;

import com.revature.dao.CustomerDAO;
import com.revature.models.Customer;

public class CustomerService {

	private CustomerDAO cdao;

	public CustomerService(CustomerDAO cdao) {
		super();
		this.cdao = cdao;
	}

	public Customer confirmLogin(String username, String password) {

		Optional<Customer> possibleCust = cdao.findAll()
				.stream()
				.filter(c -> (c.getUsername().equals(username) && c.getPassword().equals(password)))
				.findFirst();
		return (possibleCust.isPresent() ? possibleCust.get() : null);
	}

	public List<Customer> findAll() {
		return cdao.findAll();
	}

	public int insert(Customer c) {
		return cdao.insert(c);
	}

	public boolean update(Customer c) {
		return cdao.update(c);
	}

	public boolean delete(Customer c) {
		return cdao.delete(c);
	}
	
}
