package br.com.thread2.model;

public class LanceComum implements Runnable {

	private Incremento incremento;
	private Leilao leilao;
	
	public LanceComum(Incremento incremento, Leilao leilao) {
		this.incremento = incremento;
		this.leilao = leilao;
	}

	@Override
	public void run() {
		System.out.println("Iniciando Lance Comum");
		synchronized (incremento) {			
			int valorDoIncremento = incremento.getValor();
			synchronized (leilao) {	
				leilao.darLance(valorDoIncremento);
				System.out.println("O valor do produto agora é " + leilao.getValorCorrente());		
			}
		}
	}
}
