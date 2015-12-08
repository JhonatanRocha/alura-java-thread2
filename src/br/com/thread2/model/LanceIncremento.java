package br.com.thread2.model;

public class LanceIncremento implements Runnable {

	private Incremento incremento;
	private Leilao leilao;
	
	public LanceIncremento(Incremento incremento, Leilao leilao) {
		this.incremento = incremento;
		this.leilao = leilao;
	}

	/*
	 * To make a deadlock on Thread
	 * Switch incremento between leilao declaration.  
	 * 
	 */
	
	@Override
	public void run() {
		
		synchronized (incremento) {
			System.out.println("Iniciando Lance com incremento no Leilao com valor: " + leilao.getValorCorrente());
			synchronized (leilao) {			
				incremento.dobrar();
				int valorDoIncremento = incremento.getValor();
				leilao.darLance(valorDoIncremento);
				System.out.println("O valor corrente do leilao é " + leilao.getValorCorrente() + " incremento agora de " + incremento.getValor());		
			}
		}
	}
}
