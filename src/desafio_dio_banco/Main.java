package desafio_dio_banco;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
				
		Cliente clienteNovo = new Cliente();
		try (Scanner digitado = new Scanner(System.in)) {
			String nomeCliente = "";
			Double depos, trans;
			int tipoConta=0;
			
			
			System.out.println("Digite o nome do cliente: ");
			nomeCliente = digitado.nextLine();
			System.out.println("Digite o Valor do depósito:");
			depos = digitado.nextDouble();
			System.out.println("Digite o valor a ser transferido:");
			trans = digitado.nextDouble();
			System.out.println("Digite o 1 para Conta Corrente ou 2 para Conta Poupanca:");
			tipoConta = digitado.nextInt();
			
			clienteNovo.setNome(nomeCliente);
			
			Conta ccorrente = new ContaCorrente(clienteNovo);
			
			
			ccorrente.depositar(depos);
			
			Conta cpoupanca = new ContaPoupanca(clienteNovo);
			
			if (tipoConta == 1) {
				ccorrente.transferir(trans, ccorrente);
			}else {
				ccorrente.transferir(trans, cpoupanca);
			}
			
			
			ccorrente.imprimirExtrato();
			cpoupanca.imprimirExtrato();
		}
	}
	

}
