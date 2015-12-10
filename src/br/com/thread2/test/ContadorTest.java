package br.com.thread2.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.thread2.model.Contador;

public class ContadorTest {
	public static void main(String[] args) {
		//Thread[] threads = new Thread[100];
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 100; i++) {
			Contador contador = new Contador();
			executorService.execute(contador);
		}
		
		System.out.println("Fim do programa teste.");
		executorService.shutdown();
	}
}
