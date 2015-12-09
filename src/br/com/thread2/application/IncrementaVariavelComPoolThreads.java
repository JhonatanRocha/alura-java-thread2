package br.com.thread2.application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IncrementaVariavelComPoolThreads implements Runnable{

    private static Integer total = 0;

    public static void main(String[] args) {
    	
    	ExecutorService executorService = Executors.newCachedThreadPool();
    	
    	for(int i=0; i<10; i++){
    		executorService.execute(new IncrementaVariavelComPoolThreads());            
        }
    	executorService.shutdown();
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            synchronized (total) {
                total++;
                System.out.println(total);
            }
        }
    }
}
