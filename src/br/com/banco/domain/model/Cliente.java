package br.com.banco.domain.model;

import java.time.LocalDate;

public class Cliente {

	private String nome;
	private String rg;
	private String cpf;
	private LocalDate dataDeNascimento;
	
	public Cliente() {}
	
	public Cliente(String nome, String rg, String cpf, LocalDate dataDeNascimento) {
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getRg() {
		return rg;
	}
	
	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

}
