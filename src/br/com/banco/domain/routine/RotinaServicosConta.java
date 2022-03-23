package br.com.banco.domain.routine;

import java.util.Scanner;

import br.com.banco.common.ScannerManager;
import br.com.banco.domain.model.Conta;

public class RotinaServicosConta {

	public static void execute(Conta conta) {
		int opcao;
		do {
			
			System.out.println("\n#########################################");
			System.out.println("#                                       #");
			System.out.println("#                                       #");
			System.out.println("#           SERVIÇOS DA CONTA           #");
			System.out.println("#                                       #");
			System.out.println("#                                       #");
			System.out.println("# Menu de Opções:                       #");
			System.out.println("# 1 - Depositar                         #");
			System.out.println("# 2 - Sacar                             #");
			System.out.println("# 3 - Dados bancários                   #");
			System.out.println("# 4 - Voltar                            #");
			System.out.println("#                                       #");
			System.out.println("#########################################\n");
			
			Scanner sc = ScannerManager.getInstance();

			System.out.print("Opção: ");
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 1 -> {
				System.out.print("Digite valor do depósito: ");
				double valor = sc.nextDouble();
				
				conta.depositar(valor);
			}
			
			case 2 -> {
				System.out.print("Digite valor do saque: ");
				double valor = sc.nextDouble();
				
				conta.sacar(valor);
			}
			
			case 3 -> {
				conta.getDadosBancarios();
			}
			
			case 4 -> {
				break;
			}
			
			default ->
				System.out.println("Opção inválida!");
			}
			
		} while (opcao != 4);
	}
}
