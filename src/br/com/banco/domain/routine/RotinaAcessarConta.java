package br.com.banco.domain.routine;

import java.util.Scanner;

import br.com.banco.common.BancoManager;
import br.com.banco.common.ScannerManager;
import br.com.banco.domain.model.Banco;
import br.com.banco.domain.model.Conta;

public class RotinaAcessarConta {

	public static void execute() {

		System.out.println("\n#########################################");
		System.out.println("#                                       #");
		System.out.println("#                                       #");
		System.out.println("#             ACESSAR CONTA             #");
		System.out.println("#                                       #");
		System.out.println("#                                       #");
		System.out.println("#########################################\n");

		Conta contaCliente;
		
		do {
			
			Scanner sc = ScannerManager.getInstance();

			System.out.print("Digite sua agência: ");
			int agencia = sc.nextInt();

			System.out.print("Digite sua conta: ");
			int conta = sc.nextInt();
			
			System.out.print("Digite sua senha de 04 dígitos: ");
			String senha = sc.next();
			
			Banco banco = BancoManager.getInstance();
			
			contaCliente = banco.acessarConta(agencia, conta, senha);

		} while (contaCliente == null);
		
		
		RotinaServicosConta.execute(contaCliente);
		
	}
}
