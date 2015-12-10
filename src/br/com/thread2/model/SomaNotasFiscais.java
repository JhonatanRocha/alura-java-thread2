package br.com.thread2.model;

import java.util.concurrent.Callable;

public class SomaNotasFiscais implements Callable<Integer> {

	private NotaFiscal[] notasFiscais;
	private int inicio;
	private int termino;

	public SomaNotasFiscais(NotaFiscal[] notasFiscais, int inicio, int termino) {
		this.notasFiscais = notasFiscais;
		this.inicio = inicio;
		this.termino = termino;
	}

	@Override
	public Integer call() throws Exception {
		int soma = 0;
		for (int i = inicio; i < termino; i++) {
			soma += notasFiscais[i].getTotal();
		}
		return soma;
	}
}
