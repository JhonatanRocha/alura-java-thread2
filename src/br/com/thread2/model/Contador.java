package br.com.thread2.model;

public class Contador implements Runnable {

	@Override
	public void run() {
		long idThread = Thread.currentThread().getId();
		for (int i = 1; i <= 100; i++) {
			System.out.println("Thread " + idThread + " contando " + i);
		}
	}
}
