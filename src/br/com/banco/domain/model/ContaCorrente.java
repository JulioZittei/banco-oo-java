package br.com.banco.domain.model;

public class ContaCorrente extends Conta {

	public static final double tarifaSaque = 2.50;

	public ContaCorrente() {
	}

	public ContaCorrente(Cliente cliente, String senha) {
		super(cliente, senha);
	}

	@Override
	public void sacar(double valor) {
		
		if( this.saldo < (valor + tarifaSaque)) {
			System.out.println("\nSaldo Insuficiente!\n");
			return;
		}
		
		System.out.println("\n#########################################");
		System.out.println("");
		System.out.println("");
		System.out.println("        COMPROVANTE DE SAQUE          ");
		System.out.println("");
		System.out.printf( "Saldo Anterior: %f\n", this.saldo);
		System.out.printf( "Valor do Saque: %f\n", valor);
		System.out.printf( "Tarifa de Saque: %f\n", tarifaSaque);
		
		this.saldo -= (valor + tarifaSaque);
		
		System.out.printf( "Saldo Atual: %f\n", this.saldo);
		System.out.println("");
		System.out.println("");
		System.out.println("#########################################");
	}

	@Override
	public String toString() {
		return "\nNome: " + this.getCliente().getNome() + "\nRG: " + this.getCliente().getRg() 
				+ "\nCPF: " + this.getCliente().getCpf() + "\nData de nascimento: " + this.getCliente().getDataDeNascimento()
				+ "\nAgência: " + this.getAgencia() + "\nConta: " + this.getConta() + "\nSaldo: " + this.getSaldo() + "\n";
	}

}
