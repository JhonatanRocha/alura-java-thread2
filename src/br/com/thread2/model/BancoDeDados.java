package br.com.thread2.model;

import br.com.thread2.test.ProcessamentoUsuarioTest;

public class BancoDeDados {
	public static void grava(){
		String user = ProcessamentoUsuarioTest.usuarioCorrente.get();
		System.out.println("Thread" + Thread.currentThread().getId() + " - user: " + user);
	}
}
