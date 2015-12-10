package br.com.thread2.model;

import br.com.thread2.test.ProcessamentoUsuarioTest;

public class ProcessamentoUsuario implements Runnable {

	private String user;
	
	public ProcessamentoUsuario(String user) {
		this.user = user;
	}

	@Override
	public void run() {
		System.out.println("Thread" + Thread.currentThread().getId() + " - user: " + user);
		ProcessamentoUsuarioTest.usuarioCorrente.set(user);
		System.out.println("Thread" + Thread.currentThread().getId() + " - colocado na ThreadLocal: ");
		RegraDeNegocio.executa();
	}

}
