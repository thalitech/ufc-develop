package com.ufc.sistemaufc.model;

import java.math.BigDecimal;

public enum CategoriaMasculina {

	MOSCA(BigDecimal.ZERO, BigDecimal.valueOf(56.7)), 
	GALO(BigDecimal.valueOf(56.7), BigDecimal.valueOf(61.2)),
	PENA(BigDecimal.valueOf(61.2), BigDecimal.valueOf(65.7)), 
	LEVE(BigDecimal.valueOf(65.7), BigDecimal.valueOf(70.3)),
	MEIOMEDIO(BigDecimal.valueOf(70.3), BigDecimal.valueOf(77.1)),
	MEDIO(BigDecimal.valueOf(77.1), BigDecimal.valueOf(83.9)),
	MEIOPESADO(BigDecimal.valueOf(83.9), BigDecimal.valueOf(92.9)),
	PESADO(BigDecimal.valueOf(92.9), BigDecimal.valueOf(120.2));

	private BigDecimal inicio;
	private BigDecimal fim;

	private CategoriaMasculina(BigDecimal inicio, BigDecimal fim) {
		this.inicio = inicio;
		this.fim = fim;
	}

	public BigDecimal getInicio() {
		return inicio;
	}

	public void setInicio(BigDecimal inicio) {
		this.inicio = inicio;
	}

	public BigDecimal getFim() {
		return fim;
	}

	public void setFim(BigDecimal fim) {
		this.fim = fim;
	}

	public static CategoriaMasculina categoria(final BigDecimal peso) {
		for (var c : CategoriaMasculina.values()) {
			if ((peso.compareTo(c.getInicio()) > 0) && (peso.compareTo(c.getFim()) <= 0)) {

				return c;
			}
		}
		
		throw new RuntimeException(String.format("Não foi possível obter a categoria para o peso %s", peso));
	}
	
	public String toString() {
		return this.name();
	}
}
