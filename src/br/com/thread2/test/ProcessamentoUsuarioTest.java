package br.com.thread2.test;

import br.com.thread2.model.ProcessamentoUsuario;

public class ProcessamentoUsuarioTest {
	
	public static ThreadLocal<String> usuarioCorrente = new ThreadLocal<String>();
	
	public static void main(String[] args) {
		new Thread(new ProcessamentoUsuario("Kratos")).start();
		new Thread(new ProcessamentoUsuario("Chronos")).start();
		new Thread(new ProcessamentoUsuario("Zeus")).start();		
		new Thread(new ProcessamentoUsuario("Gaia")).start();
		new Thread(new ProcessamentoUsuario("Hades")).start();
	}
}
