package br.com.banco.common;

import br.com.banco.domain.model.Banco;

public class BancoManager {

private static Banco instance;
	
	public static Banco getInstance() {
		if(instance == null) {
			instance =  new Banco();
		}
		
		return instance;
	}
}
