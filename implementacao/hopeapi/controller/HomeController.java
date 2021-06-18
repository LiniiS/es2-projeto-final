package br.com.fatec.ads.es.hopeapi.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatec.ads.es.hopeapi.model.Pet;
import br.com.fatec.ads.es.hopeapi.model.StatusPet;
import br.com.fatec.ads.es.hopeapi.repository.PetRepository;

/**
 * A classe HomeController utiliza a classe experimental Pet a interface
 * PetRepository. Se trata de uma classe desenvolvida no início do projeto e
 * optou-se por não alterar para usar a classe Animal. Essa classe apresenta a
 * lista dinâmica de animais disponíveis para adoção.
 * 
 * @author xlnst
 *
 */
@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PetRepository petRepository;

	@GetMapping
	public String home(Model model, Principal principal) {

		Sort sort = Sort.by("dataDeAcolhimento").descending();

		PageRequest paginacao = PageRequest.of(0, 5, sort);

		List<Pet> pets = petRepository.findByStatus(StatusPet.AGUARDANDO, paginacao);
		Collections.shuffle(pets);
		model.addAttribute("pets", pets);
		return "home";
	}

}
