package br.com.banco.domain.routine;

import java.util.Scanner;

import br.com.banco.common.ScannerManager;
import br.com.banco.domain.service.AberturaContaCorrenteService;
import br.com.banco.domain.service.AberturaContaPoupancaService;

public class RotinaAberturaConta {

	public static void execute() {
		int opcao;

		do {
			System.out.println("\n#########################################");
			System.out.println("#                                       #");
			System.out.println("#                                       #");
			System.out.println("#           ABERTURA DE CONTA           #");
			System.out.println("#                                       #");
			System.out.println("#                                       #");
			System.out.println("# Menu de Opções:                       #");
			System.out.println("# 1 - Conta corrente                    #");
			System.out.println("# 2 - Conta poupança                    #");
			System.out.println("# 3 - Voltar                            #");
			System.out.println("#                                       #");
			System.out.println("#########################################\n");
			
			Scanner sc = ScannerManager.getInstance();

			System.out.print("Opção: ");
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 1 -> {
				AberturaContaCorrenteService.execute();
			}
			
			case 2 -> {
				AberturaContaPoupancaService.execute();
			}
			
			case 3 -> {
				break;
			}
			
			default ->
				System.out.println("Opção inválida!");
			}

		} while (opcao < 3);
	}
}
