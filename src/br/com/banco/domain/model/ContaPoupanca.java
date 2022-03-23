package br.com.banco.domain.model;

public class ContaPoupanca extends Conta{
	
	public ContaPoupanca() {}

	public ContaPoupanca(Cliente cliente, String senha) {
		super(cliente, senha);
	}
	
	@Override
	public String toString() {
		return "\nNome: " + this.getCliente().getNome() + "\nRG: " + this.getCliente().getRg() 
				+ "\nCPF: " + this.getCliente().getCpf() + "\nData de nascimento: " + this.getCliente().getDataDeNascimento()
				+ "\nAgência: " + this.getAgencia() + "\nConta: " + this.getConta() + "\nSaldo: " + this.getSaldo() + "\n";
	}

}
