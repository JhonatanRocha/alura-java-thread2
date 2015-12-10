package br.com.thread2.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import br.com.thread2.model.Fatorial;

public class FatorialTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Fatorial[] fatoriais = new Fatorial[3];
		int somadorAuxiliar = 3;
		int total = 0;
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<Integer>> resultados = new ArrayList<Future<Integer>>();
		
		for (int i = 0; i < fatoriais.length; i++) {
			fatoriais[i] = new Fatorial(somadorAuxiliar);
			Future<Integer> resultado = executorService.submit(fatoriais[i]);
			resultados.add(resultado);
			somadorAuxiliar++;
		}
		
		for (Future<Integer> resultado : resultados) {
			total += resultado.get();
		}
		
		System.out.println("O total dos fatoriais é " + total);
		executorService.shutdown();
	}
}
