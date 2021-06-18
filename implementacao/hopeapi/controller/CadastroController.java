package br.com.fatec.ads.es.hopeapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastros") // cadastros de adoção -> precisa estar logado
public class CadastroController {

	@GetMapping
	public String getFormularioDeCadastros() {
		return "cadastro/home";

	}

}
