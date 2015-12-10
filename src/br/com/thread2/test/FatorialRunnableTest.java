package br.com.thread2.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.thread2.model.FatorialRunnable;

public class FatorialRunnableTest {

	public static void main(String[] args) throws Exception{
        BlockingQueue<Long> queue = new ArrayBlockingQueue<>(3);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new FatorialRunnable(3L,queue));
        executorService.execute(new FatorialRunnable(4L,queue));
        executorService.execute(new FatorialRunnable(5L,queue));

        Long total = queue.take() + queue.take() + queue.take();

        System.out.println("Total: " + total);
        executorService.shutdown();
    }
}
