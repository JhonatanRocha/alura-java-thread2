package br.com.thread2.model;

public class Experimento {
	public static void main(String[] args) {
		Experimento experimento = new Experimento();
		experimento.executar();
	}

	private volatile int firstValue = 0;
	private volatile int secondValue = 0;
	private boolean stop = false;

	public void executar() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (!stop) {
					incrementar();
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (!stop) {
					verifica();
				}
			}
		}).start();
		;
	}

	public void incrementar() {
		firstValue++;
		secondValue++;
		if (firstValue == Integer.MAX_VALUE) {
			firstValue = 0;
			secondValue = 0;
		}
	}

	public void verifica() {
		if (secondValue > firstValue) {
			System.out.println("Something went wrong! firstValue = "
					+ firstValue + " | secondValue = " + secondValue);
			stop = true;
		} else {
			System.out.println("Everything runs fine! firstValue = "
					+ firstValue + " | secondValue = " + secondValue);
		}
	}
}
