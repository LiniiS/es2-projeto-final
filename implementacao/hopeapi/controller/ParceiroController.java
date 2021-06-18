package br.com.fatec.ads.es.hopeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatec.ads.es.hopeapi.model.Parceiro;
import br.com.fatec.ads.es.hopeapi.service.ParceiroService;

/**
 * Esta classe é responsável por conduzir o mapeamento das ações requsitadas na
 * View do Parceiro
 * 
 * @author xlnst
 *
 */
@Controller
@RequestMapping("/home/parceiros")
public class ParceiroController {

	@Autowired
	private ParceiroService parceiroService;

	// exibir todos os parceiros
	@GetMapping // lista todos
	public String home(Model model) {
		model.addAttribute("listaParceiros", parceiroService.getAllParceiros());
		return "parceiro/index";

	}

	// cadastro de parceiro
	@GetMapping("/exibirNovoParceiroForm")
	public String exibirNovoParceiroForm(Model model) {
		Parceiro parceiro = new Parceiro();
		// thymeleaf acessa "parceiro" pra popular
		model.addAttribute("parceiro", parceiro);
		return "parceiro/novo_parceiro";
	}

	@PostMapping("/salvarParceiro")
	public String salvarParceiro(@ModelAttribute("parceiro") Parceiro parceiro) {
		// salva no bd
		parceiroService.saveParceiro(parceiro);
		return "redirect:/home/parceiros";

	}

	@GetMapping("/exibirFormForUpdate/{id}")
	public String exibirFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		// pega o parceiro via service
		Parceiro parceiro = parceiroService.getParceiroById(id);

		// adiciona o parceiro como atributo ao cadstro pré-populado
		model.addAttribute("parceiro", parceiro);
		// navegação dos templates
		return "parceiro/parceiro_atualizado";

	}

	@GetMapping("/removerParceiro/{id}")
	public String removerParceiro(@PathVariable(value = "id") long id) { // n precisa criar uma nova view
		// remove usando o service
		this.parceiroService.deleteParceiroById(id);
		return "redirect:/home/parceiros";

	}

}
