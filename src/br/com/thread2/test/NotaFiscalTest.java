package br.com.thread2.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import br.com.thread2.model.NotaFiscal;
import br.com.thread2.model.SomaNotasFiscais;

public class NotaFiscalTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		NotaFiscal[] notasFiscais = new NotaFiscal[10000];
		Random random = new Random(System.currentTimeMillis());
		
		for (int i = 0; i < notasFiscais.length; i++) {
			notasFiscais[i] = new NotaFiscal(Math.abs(random.nextInt() % 1000));
		}
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<Integer>> resultados = new ArrayList<Future<Integer>>();
		
		for (int i = 0; i < notasFiscais.length; i += 100) {
			SomaNotasFiscais somador = new SomaNotasFiscais(notasFiscais, i, i+100);
			Future<Integer> resultado = executorService.submit(somador);
			resultados.add(resultado);
		}
		
		long totalNotasFiscais = 0;
		for (Future<Integer> resultado : resultados) {
			totalNotasFiscais += resultado.get();
		}
		
		System.out.println("O total das notas é " + totalNotasFiscais);
		executorService.shutdown();
	}
}
