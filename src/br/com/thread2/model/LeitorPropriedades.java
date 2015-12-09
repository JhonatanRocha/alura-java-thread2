package br.com.thread2.model;

import java.io.FileReader;
import java.util.Properties;

public class LeitorPropriedades implements Runnable {

    private Properties properties;
    private String nomeArquivo;

    public LeitorPropriedades(Properties properties, String nomeArquivo) {
        this.properties = properties;
        this.nomeArquivo = nomeArquivo;
    }

    public void run() {
        try {
            properties.load(new FileReader(nomeArquivo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
