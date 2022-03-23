package br.com.banco.domain.service;

import java.util.Scanner;

import br.com.banco.common.BancoManager;
import br.com.banco.common.ScannerManager;
import br.com.banco.common.Utils;
import br.com.banco.domain.model.Banco;
import br.com.banco.domain.model.Cliente;
import br.com.banco.domain.model.Conta;

public class AberturaContaPoupancaService {

	public static void execute() {

		System.out.println("\n#########################################");
		System.out.println("#                                       #");
		System.out.println("#                                       #");
		System.out.println("#  CADASTRO ABERTURA DE CONTA POUPANÇA  #");
		System.out.println("#                                       #");
		System.out.println("#                                       #");
		System.out.println("#########################################\n");

		Scanner sc = ScannerManager.getInstance();

		boolean hasError = false;

		String nome;
		String rg;
		String cpf;
		String dataEmTexto;
		String senha;

		do {
			System.out.print("Digite o seu nome: ");
			nome = sc.next();

			hasError = !Utils.matches("([a-zA-Z\s]{3,60})", nome);
			nome = Utils.capitalize(nome);
			if (hasError)
				System.out.println("\nNome inválido! Tente novamente.\n");
		} while (hasError);

		do {
			System.out.print("Digite o seu RG: ");
			rg = sc.next();
			hasError = !Utils.matches("([0-9]{9})", rg);
			if (hasError)
				System.out.println("\nRG inválido! Tente novamente.\n");
		} while (hasError);

		do {
			System.out.print("Digite o seu CPF: ");
			cpf = sc.next();
			hasError = !Utils.matches("([0-9]{11})", cpf);
			if (hasError)
				System.out.println("\nCPF inválido! Tente novamente.\n");
		} while (hasError);

		do {
			System.out.print("Digite sua data de nascimento: Ex: 25/12/1973 ");
			dataEmTexto = sc.next();
			hasError = !Utils.matches("([0-9]+\\/[0-9]+\\/([0-9]{4}))", dataEmTexto);
			if (hasError)
				System.out.println("\nData de nascimento inválida! Tente novamente.\n");
		} while (hasError);

		do {
			System.out.print("Crie uma senha de 04 digítos numérica: ");
			senha = sc.next();
			hasError = !Utils.matches("([0-9]{4})", senha);
			if (hasError)
				System.out.println("\nSenha fora do padrão! Tente novamente.\n");
		} while (hasError);

		Cliente cliente = new Cliente(nome, rg, cpf, Utils.toLocalDate(dataEmTexto, "dd/MM/yyyy"));

		Banco banco = BancoManager.getInstance();
		Conta contaAberta = banco.abrirContaPoupanca(cliente, senha);

		contaAberta.getDadosBancarios();

	}
}
