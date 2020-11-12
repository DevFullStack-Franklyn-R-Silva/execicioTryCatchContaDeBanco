package model.entities;

import model.exceptions.DomainException;

public class Conta {
	private Integer numeroConta;
	private String titular;
	private Double saldo;
	private Double limiteRetirada;

	// construtor
	public Conta() {
	}

	public Conta(Integer numeroConta, String titular, Double saldo, Double limiteRetirada) {
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteRetirada = limiteRetirada;
	}

	// get e set
	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteRetirada() {
		return limiteRetirada;
	}

	public void setLimiteRetirada(Double limiteRetirada) {
		this.limiteRetirada = limiteRetirada;
	}

	// métodos
	public void depositar(double montante) {
		this.saldo += montante;
	}

	public void sacar(double montante) {
		if(montante > limiteRetirada) {
			throw new DomainException("O valor excede o limite de saque!");
		}
		if(montante > saldo) {
			throw new DomainException("Não há saldo suficiente!");
		}
		this.saldo -=montante;
	}

}
