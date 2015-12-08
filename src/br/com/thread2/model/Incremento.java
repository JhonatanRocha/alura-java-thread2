package br.com.thread2.model;

public class Incremento {
	private int valor;

	public Incremento(int inicial) {
		this.valor = inicial;
	}

	public int getValor() {
		return valor;
	}
	
	public void dobrar(){
		valor = valor * 2;
	}
	
}
