package br.com.to;

import java.io.Serializable;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idCustomer;
	private String cpfCnpj;
	private String nmCustomer;
	private boolean isActive;
	private double vlTotal;
		
	public Customer() {
		
	}
	
	public Customer(int idCustomer){
		super();
		this.idCustomer = idCustomer;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNmCustomer() {
		return nmCustomer;
	}

	public void setNmCustomer(String nmCustomer) {
		this.nmCustomer = nmCustomer;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public double getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(double vlTotal) {
		this.vlTotal = vlTotal;
	}
	
	@Override
	public String toString() {
		return "Customer [ID Customer=" + idCustomer + ", CPF/CNPJ=" + cpfCnpj
				+ ", Nome Customer=" + nmCustomer + ", Status=" + isActive
				+ ", Valor Total=" + vlTotal + "]";
	}
	
	
}
