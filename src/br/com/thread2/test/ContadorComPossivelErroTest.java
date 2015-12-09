package br.com.thread2.test;

import java.lang.Thread.UncaughtExceptionHandler;

import br.com.thread2.model.ContadorComPossivelErro;

public class ContadorComPossivelErroTest {
	public static void main(String[] args) {
		
		Thread.UncaughtExceptionHandler threadExceptionHandler = new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Erro capturado: " + e.getMessage());
			}
		};
		
		Thread thread1 = new Thread(new ContadorComPossivelErro(1));
		thread1.setUncaughtExceptionHandler(threadExceptionHandler);
		
		Thread thread2 = new Thread(new ContadorComPossivelErro(2));
		thread2.setUncaughtExceptionHandler(threadExceptionHandler);
		
		Thread thread3 = new Thread(new ContadorComPossivelErro(3,4));
		thread3.setUncaughtExceptionHandler(threadExceptionHandler);
		
		Thread thread4 = new Thread(new ContadorComPossivelErro(4));
		thread4.setUncaughtExceptionHandler(threadExceptionHandler);
		
		Thread thread5 = new Thread(new ContadorComPossivelErro(5,8));
		thread5.setUncaughtExceptionHandler(threadExceptionHandler);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}
}
