package br.com.main;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.bo.CustomerBO;
import br.com.to.Customer;
public class Inicial {

	public static void main(String[] args) {

		Scanner scann = new Scanner(System.in);

		System.out.println("**** Inicio do Sistema ****");

		int opcao = 1;

		while (opcao != 3) {

			System.out.println("Escolha uma opcao:");
			//System.out.println("[0] Incluir Um Customer"); customerBO.incluir(customer);
			System.out.println("[1] Incluir Varios");
			System.out.println("[2] Listar");
			System.out.println("[3] Sair");
			System.out.print("->");

			opcao = scann.nextInt();

			switch (opcao) {
			/*
			case 0: {
				Customer customer = new Customer();
					
					//IMPORTANTE: NESTE CASO, NAO CRIEI UMA 'SEQUENCE' NO BANCO POR ESSE MOTIVO, COLOQUEI PARA QUE O USUARIO ESCREVESSE O ID_CUSTOMER
					
					System.out.print("ID:");
					customer.setIdCustomer(scann.nextInt());
					
					System.out.print("Nome:");
					customer.setNmCustomer((scann.next() + scann.nextLine()));
					
					System.out.print("Cpf/Cnpj:");
					customer.setCpfCnpj((scann.next() + scann.nextLine()));
					
					System.out.print("Valor Total:");
					customer.setVlTotal(scann.nextDouble());
					
					System.out.print("O Customer está ativo? [0]-NAO,[1]-SIM:");
					int ativo = scann.nextInt();
					if(ativo == 1)
						customer.setIsActive(true);
					else
						customer.setIsActive(false);
					
					CustomerBO customerBO = new CustomerBO();
					customerBO.incluir(customer);
			
					break;
			}
			*/
			case 1: {
				CustomerBO customerBO = new CustomerBO();
				customerBO.incluirVarios();
				break;
			}
			case 2: {
				CustomerBO customerBO = new CustomerBO();

				ArrayList<Customer> listaCustomer = customerBO.listarTodos();
				double mediaFinal = customerBO.media();
				String status = "";
				StringBuilder sb = new StringBuilder();
				for(Customer customer: listaCustomer){
					
					if(customer.getIsActive() == true) {
						status = "Ativo";
					}else {
						status = "Inativo";
					}
					
					sb.append("Nome: ").append(customer.getNmCustomer()).append(" - CPF/CNPJ: ").append(customer.getCpfCnpj());
					sb.append(" - Valor Total: ").append(customer.getVlTotal()).append(" - Status: ").append(status);
					sb.append("\n");
				}

				System.out.println(sb.toString());
				if (mediaFinal != 0.0) {
					System.out.println("Media Final: " + mediaFinal);
				}else {
					System.out.println("Não existe dados nessas condições!");
				}
				break;
			}
			case 3: {

				scann.close();
				System.exit(0);

				break;
			}
			default: {

				System.err.println("Opcao invalida!");
				opcao = 1;
			}

			}
		}
	}
}
