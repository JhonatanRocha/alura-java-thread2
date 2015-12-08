package br.com.thread2.test;

import br.com.thread2.model.Incremento;
import br.com.thread2.model.LanceComum;
import br.com.thread2.model.LanceIncremento;
import br.com.thread2.model.Leilao;

public class LeilaoTest {
	
	public static void main(String[] args) {		
		Leilao leilao = new Leilao(1000);
		Incremento incremento = new Incremento(150);
		
		Thread thread1 = new Thread(new LanceComum(incremento, leilao));
		Thread thread2 = new Thread(new LanceIncremento(incremento, leilao));
		
		thread1.start();
		thread2.start();
	}
}
