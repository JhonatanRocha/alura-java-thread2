package br.com.thread2.model;

public class ContadorComPossivelErro implements Runnable {

	private int darErro = -1;
	private int numeroDaThread;
	
	public ContadorComPossivelErro(int numeroDaThread) {
		this.numeroDaThread = numeroDaThread;
	}
	
	public ContadorComPossivelErro(int numeroDaThread, int darErro) {
		this.numeroDaThread = numeroDaThread;
		this.darErro = darErro;
	}
	
	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			if(i == darErro){
				throw new RuntimeException("ERRO na Thread " + numeroDaThread + " ao contar " + i);
			}
			System.out.println("Thread " + numeroDaThread + " conta " + i);
		}
	}
}
