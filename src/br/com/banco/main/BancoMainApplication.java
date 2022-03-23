package br.com.banco.main;

import java.util.Scanner;

import br.com.banco.common.ScannerManager;
import br.com.banco.domain.routine.RotinaAberturaConta;
import br.com.banco.domain.routine.RotinaAcessarConta;

public class BancoMainApplication {

	public static void main(String[] args) {

		Scanner sc = ScannerManager.getInstance();

		int opcao;

		do {
			System.out.println("\n#########################################");
			System.out.println("#                                       #");
			System.out.println("#                                       #");
			System.out.println("#          BEM-VINDO AO BANCO           #");
			System.out.println("#                                       #");
			System.out.println("#                                       #");
			System.out.println("#        INSTRUÇÕES DA APLICAÇÃO        #");
			System.out.println("#                                       #");
			System.out.println("#                                       #");
			System.out.println("# Menu de Opções:                       #");
			System.out.println("# 1 - Abertura de conta                 #");
			System.out.println("# 2 - Acessar conta                     #");
			System.out.println("# 3 - Sair da Aplicação                 #");
			System.out.println("#                                       #");
			System.out.println("#########################################\n");

			System.out.print("Opção: ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1 -> {
				RotinaAberturaConta.execute();
			}

			case 2 -> {

				RotinaAcessarConta.execute();
			}

			case 3 -> {
				break;
			}

			default -> System.out.println("Opção inválida!");
			}

		} while (opcao != 3);

		System.out.println("\n#########################################");
		System.out.println("#                                       #");
		System.out.println("#                                       #");
		System.out.println("#    OBRIGADOR POR UTILIZAR O BANCO     #");
		System.out.println("#                                       #");
		System.out.println("#                                       #");
		System.out.println("#########################################");

	}

}