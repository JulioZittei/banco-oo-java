package br.com.banco.domain.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import br.com.banco.common.Utils;


public class Conta implements Authenticacao{
	
	protected Cliente cliente;
	protected int agencia;
	protected int conta;
	protected double saldo;
	protected String senha;
	protected OffsetDateTime dataDeAbertura;
	
	
	public Conta () {}
	
	public Conta (int agencia, int conta ) {
		this.agencia = agencia;
		this.conta = conta;
	}
	
	public Conta (Cliente cliente, String senha) {
		this.agencia = (int) (Math.random() * 1000);
		this.conta = (int) (Math.random() * 1000);
		this.dataDeAbertura = OffsetDateTime.now();
		this.saldo = 0.0;
		this.setCliente(cliente);
		this.senha = senha;
	}	
	
	public void getDadosBancarios() {
		System.out.println("\n#########################################");
		System.out.println("");
		System.out.println("");
		System.out.println("           DADOS BANCÁRIOS            ");
		System.out.println("");
		System.out.printf( "Agência: %d\n", this.agencia);
		System.out.printf( "Conta: %d\n", this.conta);
		System.out.printf( "Titular: %s\n", this.cliente.getNome());
		System.out.printf ("Saldo: %f\n", this.saldo);
		System.out.printf ("Data de Abertura: %s\n", Utils.toString(this.dataDeAbertura, "dd/MM/yyyy"));
		System.out.println("");
		System.out.println("");
		System.out.println("#########################################");
	}
	
	public void depositar(double valor) {
		System.out.println("\n#########################################");
		System.out.println("");
		System.out.println("");
		System.out.println("        COMPROVANTE DE DEPÓSITO          ");
		System.out.println("");
		System.out.printf( "Saldo Anterior: %f\n", this.saldo);
		System.out.printf( "Valor do Depósito: %f\n", valor);
		
		this.saldo += valor;
		
		System.out.printf( "Saldo Atual: %f\n", this.saldo);
		System.out.println("");
		System.out.println("");
		System.out.println("#########################################");
	
		
	}
	
	public void saldo() {
		System.out.println("\n#########################################");
		System.out.println("");
		System.out.println("");
		System.out.println("        COMPROVANTE DE SALDO          ");
		System.out.println("");
		System.out.println("");
		System.out.printf( "Saldo Atual: %f\n", this.saldo);
		System.out.println("");
		System.out.println("");
		System.out.println("#########################################");
	}
	
	public void sacar(double valor) {
		
		if(this.saldo < valor) {
			System.out.println("/nSaldo Insuficiente!/n");
		}
		
		System.out.println("\n#########################################");
		System.out.println("");
		System.out.println("");
		System.out.println("        COMPROVANTE DE SAQUE          ");
		System.out.println("");
		System.out.printf( "Saldo Anterior: %f\n", this.saldo);
		System.out.printf( "Valor do Saque: %f\n", valor);
		
		this.saldo -= valor;
		
		System.out.printf( "Saldo Atual: %f\n", this.saldo);
		System.out.println("");
		System.out.println("");
		System.out.println("#########################################");
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getConta() {
		return conta;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getSenha() {
		return senha;
	}

	public OffsetDateTime getDataDeAbertura() {
		return dataDeAbertura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencia, conta);
	}
	
	@Override
	public boolean authenticar(String senha) {
		return this.senha.equals(senha) ? true : false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return agencia == other.agencia && conta == other.conta;
	}	
}