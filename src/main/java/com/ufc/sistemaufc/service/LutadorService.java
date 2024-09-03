package com.ufc.sistemaufc.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ufc.sistemaufc.model.CategoriaFeminina;
import com.ufc.sistemaufc.model.CategoriaMasculina;
import com.ufc.sistemaufc.model.Login;
import com.ufc.sistemaufc.model.Lutador;
import com.ufc.sistemaufc.repository.LutadorRepository;

@Service
public class LutadorService {

	@Autowired
	private LutadorRepository lutadorRepository;

	@Value("${ufc.usuario}")
	private String usuario;

	@Value("${ufc.senha}")
	private String senha;

	public List<Lutador> todosLutadores() {
		return this.lutadorRepository.todosLutadores();
	}

	public void adicionaLutador(final Lutador lutador) {
		this.lutadorRepository.adicionaLutador(lutador);
	}

	public boolean login(Login login) {
		if (login.getUsuario().equals(this.usuario) && login.getSenha().equals(this.senha)) {
			return true;
		}
		return false;
	}

	public List<Lutador> buscaLutador(final Lutador lutador) {

		List<Lutador> resultado = this.todosLutadores();

		resultado.forEach(System.out::println);
		System.out.println(lutador.getNome());

		if ((lutador.getNome() != null) && !lutador.getNome().isEmpty()) {
			resultado = resultado.stream().filter(e -> e.getNome().equalsIgnoreCase(lutador.getNome()))
					.collect(Collectors.toList());
		}

		if (lutador.getPeso() != null) {
			resultado = resultado.stream().filter(e -> e.getPeso().equals(lutador.getPeso()))
					.collect(Collectors.toList());
		}

		if ((lutador.getCategoria() != null) && !lutador.getCategoria().isEmpty()) {

			resultado = resultado.stream().filter(e -> e.getCategoria().equalsIgnoreCase(lutador.getCategoria()))
					.collect(Collectors.toList());
		}

		if ((lutador.getCidade() != null) && !lutador.getCidade().isEmpty()) {
			resultado = resultado.stream().filter(e -> e.getCidade().equalsIgnoreCase(lutador.getCidade()))
					.collect(Collectors.toList());
		}
		if ((lutador.getEstado() != null) && !lutador.getEstado().isEmpty()) {
			resultado = resultado.stream().filter(e -> e.getEstado().equalsIgnoreCase(lutador.getEstado()))
					.collect(Collectors.toList());
		}

		return resultado;
	}

	public String descubraCategoria(final double peso, final String sexo) {
		try {

			if (sexo.equalsIgnoreCase("M")) {
				return CategoriaMasculina.categoria(BigDecimal.valueOf(peso)).name();
			}
			return CategoriaFeminina.categoria(BigDecimal.valueOf(peso)).name();

		} catch (Exception e) {
			return "O peso informado nao condiz com nenhuma categoria";
		}
	}

	public String estimarPeso(final Double peso, final String sexo) {
		String resposta = "";

		if ("M".equalsIgnoreCase(sexo)) {
			for (var c : CategoriaMasculina.values()) {
				// se o peso esta abaixo da categoria
				if (BigDecimal.valueOf(peso).compareTo(c.getInicio()) < 0) {
					resposta += "<p> Faltam " + (c.getInicio().subtract(BigDecimal.valueOf(peso)))
							+ " Kg para a categoria " + c.name() + "</p>";

					// se o peso esta dentro da faixa de uma categoria
				} else if ((BigDecimal.valueOf(peso).compareTo(c.getInicio()) >= 0)
						&& (BigDecimal.valueOf(peso).compareTo(c.getFim()) <= 0)) {
					resposta += "<p> Seu peso pertence a categoria " + c.name() + "</p> ";

					// se peso ultrapassou a categoria
				} else {
					resposta += "<p> Seu peso ultrapassou a categoria " + c.name() + " em "
							+ (BigDecimal.valueOf(peso).subtract(c.getFim())) + "Kg </p>";
				}
			}
		} else {
			for (var c : CategoriaFeminina.values()) {
				// se o peso esta abaixo da categoria
				if (BigDecimal.valueOf(peso).compareTo(c.getInicio()) < 0) {
					resposta += "<p> Faltam " + (c.getInicio().subtract(BigDecimal.valueOf(peso)))
							+ " Kg para a categoria " + c.name() + "</p>";

					// se o peso esta dentro da faixa de uma categoria
				} else if ((BigDecimal.valueOf(peso).compareTo(c.getInicio()) >= 0)
						&& (BigDecimal.valueOf(peso).compareTo(c.getFim()) <= 0)) {
					resposta += "<p> Seu peso pertence a categoria " + c.name() + "</p> ";

					// se peso ultrapassou a categoria
				} else {
					resposta += "<p> Seu peso ultrapassou a categoria " + c.name() + " em "
							+ (BigDecimal.valueOf(peso).subtract(c.getFim())) + "Kg </p>";
				}
			}
		}
		return (resposta != "") ? resposta : "Nao foi possivel encontrar uma categoria com o peso: " + peso;
	}

	public List<Lutador> agendarLuta(final Double peso, final String sexo) {

		return lutadorRepository.todosLutadores().stream().filter(
				e -> descubraCategoria(peso, sexo).equalsIgnoreCase(descubraCategoria(e.getPeso(), e.getSexo())))
				.collect(Collectors.toList());
	}
}
