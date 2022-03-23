package br.com.banco.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	public static final int BANCO = 237;

	private List<Conta> contas = new ArrayList<>();

	public List<Conta> getContas() {
		return contas;
	}

	public Conta abrirContaCorrente(Cliente cliente, String senha) {
		Conta novaConta = new ContaCorrente(cliente, senha);
		getContas().add(novaConta);
		return novaConta;
	}

	public Conta abrirContaPoupanca (Cliente cliente, String senha) {
		Conta novaConta = new ContaPoupanca(cliente, senha);
		getContas().add(novaConta);
		return novaConta;
	}
	
	public Conta acessarConta(int agencia, int conta, String senha) {
		Conta contaFiltrada = getContas().stream().filter(c -> (c.getAgencia() == agencia && c.getConta() == conta)).findFirst().orElse(null);
	
		if(contaFiltrada == null || !contaFiltrada.authenticar(senha)) {
			System.out.println("\nAgência, conta e/ou senha inválidas!\n");			
			return null;
		}
		
		return contaFiltrada;
		
	}

}
