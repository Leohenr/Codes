package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.to.Customer;

public class CustomerDAO {

	static List<Customer> listaCustomers = new ArrayList<>();

	public void incluir(Customer customer) {
		Connection conn = null;

		try {
			conn = ConnectionManager.getInstance().getConnection();
			
			PreparedStatement stmtInsert = conn.prepareStatement("Insert into tb_customer_account"
					+ " (id_customer, cpf_cnpj, nm_customer, is_active, vl_total)"
					+ " VALUES (?,?,?,?,?)");
			
			stmtInsert.setInt(1, customer.getIdCustomer());
			stmtInsert.setString(2, customer.getCpfCnpj());
			stmtInsert.setString(3, customer.getNmCustomer());
			stmtInsert.setBoolean(4, customer.getIsActive());
			stmtInsert.setDouble(5, customer.getVlTotal());
			stmtInsert.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erro ao inserir customer");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void incluirVarios(){
		
		for (int i = 1; i <= 50; i++) {
			int cpfCnpj = 123 + i;
			double valorTotal = 540.00d + i;
			Customer customer = new Customer();
			
			customer.setIdCustomer(i);
			customer.setCpfCnpj(Integer.toString(cpfCnpj));
			customer.setNmCustomer("Leonardo " + i);
			customer.setIsActive(true);
			customer.setVlTotal(valorTotal);
			
			listaCustomers.add(customer);
		}
		
		for(Customer customer : listaCustomers){

		     incluir(customer);
		}

		System.out.println("Inclusão de Customers concluída!");
	}

	public ArrayList<Customer> listarTodos() {
		Connection conn = null;
		
		ArrayList<Customer> retorno = new ArrayList<Customer>();
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT id_customer, cpf_cnpj, nm_customer, is_active, vl_total"
					+ " FROM tb_customer_account"
					+ " WHERE vl_total > 560 AND id_customer BETWEEN 15 AND 27"
					+ " ORDER BY vl_total DESC");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setIdCustomer(rs.getInt("ID_CUSTOMER"));
				customer.setCpfCnpj(rs.getString("CPF_CNPJ"));
				customer.setNmCustomer(rs.getString("NM_CUSTOMER"));
				customer.setIsActive(rs.getBoolean("IS_ACTIVE"));
				customer.setVlTotal(rs.getLong("VL_TOTAL"));
				retorno.add(customer);
			}
		} catch (SQLException e) {
			System.err.println("Erro ao executar query (listarTodos)!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return retorno;
	}
	public double media() {
		Connection conn = null;
		
		double retorno = 0;
		try {
			conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT AVG(vl_total) as MEDIA FROM tb_customer_account"
					+ " WHERE vl_total > 560 AND id_customer BETWEEN 15 AND 27");
			ResultSet rs = stmt.executeQuery();
			rs.next();
			retorno = rs.getLong("MEDIA");
			
		} catch (SQLException e) {
			System.err.println("Erro ao executar query (media)!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return retorno;
	}
}
