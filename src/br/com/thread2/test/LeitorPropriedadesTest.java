package br.com.thread2.test;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Properties;

import br.com.thread2.model.LeitorPropriedades;

public class LeitorPropriedadesTest {

    Properties properties1;
    Properties properties2;
    Properties properties3;

    Thread.UncaughtExceptionHandler threadExceptionHandler = new UncaughtExceptionHandler() {
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("Erro capturado na leitura do arquivo: " + e.getMessage() + "" + t.getId());
		}
	};
	
    public void lerPropriedades(){
    	Thread thread1 = new Thread(new LeitorPropriedades(properties1, "name-list1.txt"));
		thread1.setUncaughtExceptionHandler(threadExceptionHandler);
    	
		Thread thread2 = new Thread(new LeitorPropriedades(properties2, "name-list2.txt"));
		thread2.setUncaughtExceptionHandler(threadExceptionHandler);
		
		Thread thread3 = new Thread(new LeitorPropriedades(properties3, "name-list3.txt"));
		thread3.setUncaughtExceptionHandler(threadExceptionHandler);
		
		thread1.start();
		thread2.start();
		thread3.start();
    }
    
    private void lerPropriedadesEmParalelo(Properties properties, String nomeArquivo) {
        LeitorPropriedades leitor1 = new LeitorPropriedades(properties, nomeArquivo);
        Thread t1 = new Thread(leitor1);
        t1.setUncaughtExceptionHandler(threadExceptionHandler);
        t1.start();
        
        LeitorPropriedades leitor2 = new LeitorPropriedades(properties, nomeArquivo);
        Thread t2 = new Thread(leitor2);
        t2.setUncaughtExceptionHandler(threadExceptionHandler);
        t2.start();
        
        LeitorPropriedades leitor3 = new LeitorPropriedades(properties, nomeArquivo);
        Thread t3 = new Thread(leitor3);
        t3.setUncaughtExceptionHandler(threadExceptionHandler);
        t3.start();
    }
}
