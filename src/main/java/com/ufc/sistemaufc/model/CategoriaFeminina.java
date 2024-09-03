package com.ufc.sistemaufc.model;

import java.math.BigDecimal;

public enum CategoriaFeminina {
	
	PALHA(BigDecimal.ZERO, BigDecimal.valueOf(52)),
	MOSCA(BigDecimal.valueOf(52), BigDecimal.valueOf(52.2)),
	GALO(BigDecimal.valueOf(52.2), BigDecimal.valueOf(61.1)),
	PENA(BigDecimal.valueOf(61.1), BigDecimal.valueOf(65.7));

	
	private BigDecimal inicio;
	private BigDecimal fim;

	private CategoriaFeminina(BigDecimal inicio, BigDecimal fim) {
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

	public static CategoriaFeminina categoria(final BigDecimal peso) {
		for (var c : CategoriaFeminina.values()) {
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
