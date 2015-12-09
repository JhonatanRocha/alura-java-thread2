package br.com.thread2.model;

public class Leilao {

	private int valorCorrente;
	
	public Leilao(int lanceInicial){
		this.valorCorrente = lanceInicial;
	}
	
	public int getValorCorrente(){
		return valorCorrente;
	}
	
	public void darLance(int incremento){
		this.valorCorrente = valorCorrente + incremento;
	}
}
