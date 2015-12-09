package br.com.thread2.application;

import java.io.File;

public class Deadlock {

    public static File arquivo1 = new File("arquivo1");
    public static File arquivo2 = new File("arquivo2");

    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {

                synchronized (arquivo1) {

                    System.out.println("Thread 1 ­ Adquiriu arquivo 1");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    synchronized (arquivo2) {
                        try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
                        System.out.println("Thread 1 ­ Adquiriu arquivo 2");
                        System.out.println("Thread 1 executou");
                    }
                }
            }
        }).start();

        
        //Switch between arquivo1 and arquivo2 to make an deadlock
        new Thread(new Runnable() {
            public void run() {

                synchronized (arquivo1) {

                    System.out.println("Thread 2 ­ Adquiriu arquivo 1");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    synchronized (arquivo2) {
                        ;
                        System.out.println("Thread 2 ­ Adquiriu arquivo 2");
                        System.out.println("Thread 2 executou");
                    }
                }
            }
        }).start();
    }
}