package com.ufc.sistemaufc.model;

public class EstimarPeso {

    private Double peso;
    private String sexo;

    public EstimarPeso() {
	super();
    }

    public EstimarPeso(Double peso, String sexo) {
	super();
	this.peso = peso;
	this.sexo = sexo;
    }

    public Double getPeso() {
	return peso;
    }

    public void setPeso(Double peso) {
	this.peso = peso;
    }

    public String getSexo() {
	return sexo;
    }

    public void setSexo(String sexo) {
	this.sexo = sexo;
    }
}
