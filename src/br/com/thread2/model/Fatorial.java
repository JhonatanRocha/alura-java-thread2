package br.com.thread2.model;

import java.util.concurrent.Callable;

public class Fatorial implements Callable<Integer>{

	private int numero;
	
	public Fatorial(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}
	
	public int calculaFatorial(){
		int fatorial=1;
		
		for(int i=numero;i>=2;i--){
			fatorial= fatorial * (i);
		}

		return fatorial;
	}
	
	@Override
	public Integer call() throws Exception {
		int fatorial=1;
		
		for(int i=numero;i>=2;i--){
			fatorial= fatorial * (i);
		}

		return fatorial;
	}

}
