package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Insira os dados da conta: ");
		System.out.println("Número da Conta: ");
		int numeroConta = sc.nextInt();
		
		System.out.println("Nome do Titular: ");
		String titular = sc.next();
		
		System.out.println("Depositar: ");
		double saldo = sc.nextDouble();		
		
		System.out.println("Limite de saque: ");
		double limiteRetirada = sc.nextDouble();
		
		Conta conta = new Conta(numeroConta, titular, saldo, limiteRetirada);
		System.out.println();
		
		System.out.println("Insira o valor para sacar: ");
		double montante = sc.nextDouble();
		
		try {
			conta.sacar(montante);
			System.out.println("Novo saldo: " + String.format("%.2f", conta.getSaldo()));
		}
		catch(DomainException e) {
			System.out.println("Error de retirada: " + e.getMessage());
		}
		
		
		sc.close();
	}

}
