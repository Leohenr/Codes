package br.com.bo;

import java.util.ArrayList;

import br.com.dao.CustomerDAO;
import br.com.to.Customer;

public class CustomerBO {

	public void incluir(Customer customer) {
		CustomerDAO customeroDAO = new CustomerDAO();
		customeroDAO.incluir(customer);
	}
	public void incluirVarios() {
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.incluirVarios();
	}
	public ArrayList<Customer> listarTodos() {
		CustomerDAO customeroDAO = new CustomerDAO();
		return customeroDAO.listarTodos();
	}
	public double media() {
		CustomerDAO customeroDAO = new CustomerDAO();
		return customeroDAO.media();
	}

}
