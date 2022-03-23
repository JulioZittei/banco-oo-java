package br.com.banco.common;

import java.util.Scanner;

public class ScannerManager {

	private static Scanner instance;
	
	public static Scanner getInstance() {
		if(instance == null) {
			instance = new Scanner(System.in);
		}
		
		return instance;
	}
}
