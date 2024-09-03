package com.ufc.sistemaufc.repository;

import java.io.*;
import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.ufc.sistemaufc.model.Lutador;

@Component
public class LutadorRepository {

    private static final String CSV_DELIMITER = ";";
	
    private List<Lutador> lutadores = new ArrayList<>();

    @PostConstruct
    public void carregarListaBaseLutadores() {
	
	try (BufferedReader br =
	     new BufferedReader(new FileReader("lutadores.csv"))) {
		
	    boolean primeiraLinha = true;
	    String line;
		
	    while ((line = br.readLine()) != null) {
		if (!primeiraLinha) {
		    String[] values = line.split(CSV_DELIMITER);
		    Lutador lutador = decodLinhaCSV(values);
		    System.out.println(lutador.toString());
		    lutadores.add(lutador);
		} else {
		    primeiraLinha = false;
		}
	    }
	} catch (Exception e) {
	    System.err.println("Falha ao carregar lista de lutadores " + e);
	}
    }
	
/**
 * metodo que consulta todos os lutadores
 * @return
 */
    public List<Lutador> todosLutadores() { 
	return this.lutadores;
    }
	
/**
 * Metodo que adiciona lutador
 * @param lutador
 */
    public void adicionaLutador(final Lutador lutador) { 
	this.lutadores.add(lutador);
    }

    private Lutador decodLinhaCSV(final String []linha) {
	var lutador = new Lutador();
	lutador.setUsuario(linha[0]);
	lutador.setNome(linha[1]);
	lutador.setIdade(Integer.parseInt(linha[2]));
	lutador.setSexo(linha[3]);
	lutador.setCpf(linha[4]);
	lutador.setEmail(linha[5]);
	lutador.setCelular(linha[6]);
	lutador.setPeso(Double.parseDouble(linha[7]));
	lutador.setCategoria(linha[8]);
	lutador.setCidade(linha[9]);
	lutador.setEstado(linha[10]);
	lutador.setPais(linha[11]);	    
	return lutador;
    }
}
