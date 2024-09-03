package com.ufc.sistemaufc.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.sistemaufc.model.DescobrirCategoria;
import com.ufc.sistemaufc.model.EstimarPeso;
import com.ufc.sistemaufc.model.AgendarLuta;
import com.ufc.sistemaufc.model.Login;
import com.ufc.sistemaufc.model.Lutador;
import com.ufc.sistemaufc.service.LutadorService;

@Controller
public class LutadorController {

	@Autowired
	private LutadorService lutadorService;

	@GetMapping
	public ModelAndView login() {

		var modelAndView = new ModelAndView("acesso");

		modelAndView.addObject("login", new Login());

		return modelAndView;
	}

	@GetMapping("/menu")
	public ModelAndView menu() {
		var modelAndView = new ModelAndView("menu");
		return modelAndView;
	}

	@GetMapping("/cadastro")
	public ModelAndView telaCadastro() {

		var modelAndView = new ModelAndView("cadastro");

		modelAndView.addObject("lutador", new Lutador());

		modelAndView.addObject("lutadores", this.lutadorService.todosLutadores());

		return modelAndView;
	}

	@GetMapping("/busca")
	public ModelAndView busca() {

		var modelAndView = new ModelAndView("busca");

		modelAndView.addObject("lutador", new Lutador());

		modelAndView.addObject("lutadores", new ArrayList<>());

		return modelAndView;
	}

	@GetMapping("/descubra")
	public ModelAndView descobrirCategoria() {
		var modelAndView = new ModelAndView("descubra");
		modelAndView.addObject("descobrirCategoria", new DescobrirCategoria());
		modelAndView.addObject("categoria", "");
		return modelAndView;
	}

	@GetMapping("/estimarpeso")
	public ModelAndView estimarPeso() {
		var modelAndView = new ModelAndView("estimarpeso");
		modelAndView.addObject("estimarPeso", new EstimarPeso());
		modelAndView.addObject("mensagereturn", "");
		return modelAndView;
	}

	@GetMapping("/agendarluta")
	public ModelAndView agendarLuta() {
		var modelAndView = new ModelAndView("agendarluta");
		modelAndView.addObject("agendarLuta", new AgendarLuta());
		modelAndView.addObject("mensagereturn", "");
		return modelAndView;
	}

	@GetMapping("/lutaaleatoria")
	public ModelAndView lutaAleatoria() {
		var modelAndView = new ModelAndView("lutaaleatoria");
		return modelAndView;
	}

	@PostMapping("/adiciona")
	public ModelAndView adicionaLutador(@ModelAttribute Lutador lutador, BindingResult result) {
		this.lutadorService.adicionaLutador(lutador);
		return this.telaCadastro();
	}

	@PostMapping("/procura")
	public ModelAndView buscaLutador(@ModelAttribute Lutador lutador, BindingResult result) {

		var modelAndView = new ModelAndView("busca");

		modelAndView.addObject("lutador", lutador);

		modelAndView.addObject("lutadores", this.lutadorService.buscaLutador(lutador));

		return modelAndView;

	}

	@PostMapping("/descobrir")
	public ModelAndView descobrirCategoria(@ModelAttribute DescobrirCategoria descobrirCategoria,
			BindingResult result) {

		var modelAndView = new ModelAndView("descubra");
		modelAndView.addObject("descobrirCategoria", descobrirCategoria);
		modelAndView.addObject("categoria", this.lutadorService
				.descubraCategoria(Double.valueOf(descobrirCategoria.getPeso()), descobrirCategoria.getSexo()));
		return modelAndView;
	}

	@PostMapping("/estimar")
	public ModelAndView estimarPeso(@ModelAttribute EstimarPeso estimarPeso, BindingResult result) {

		var modelAndView = new ModelAndView("estimarpeso");
		modelAndView.addObject("estimarPeso", new EstimarPeso());
		modelAndView.addObject("mensagereturn",
				this.lutadorService.estimarPeso(estimarPeso.getPeso(), estimarPeso.getSexo()));
		return modelAndView;
	}

	@PostMapping("/agendarluta")
	public ModelAndView agendarLuta(@ModelAttribute AgendarLuta agendarLuta, BindingResult result) {
		
		var modelAndView = new ModelAndView("agendarluta");
		modelAndView.addObject("agendarLuta", agendarLuta);
		modelAndView.addObject("lutadores",
				this.lutadorService.agendarLuta(agendarLuta.getPeso(), agendarLuta.getSexo()));
		return modelAndView;
	}

	@PostMapping("/acesso")
	public ModelAndView adicionaLutador(@ModelAttribute Login login, BindingResult result) {

		return this.lutadorService.login(login) ? this.menu() : this.login();
	}
}
