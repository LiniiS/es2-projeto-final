package br.com.fatec.ads.es.hopeapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatec.ads.es.hopeapi.dto.RequisicaoNovoPet;
import br.com.fatec.ads.es.hopeapi.model.Pet;
import br.com.fatec.ads.es.hopeapi.model.User;
import br.com.fatec.ads.es.hopeapi.repository.PetRepository;
import br.com.fatec.ads.es.hopeapi.repository.UserRepository;
import br.com.fatec.ads.es.hopeapi.service.PetService;

/**
 * Classe experimental: criada no início do projeto e será continuada para ser
 * utilizada na aplicação, para fins didáticos a classe foi substituída pela
 * classe AnimalController
 * 
 * @author xlnst
 *
 */
@Controller
@RequestMapping("pet")
public class PetController {

	@Autowired
	private PetRepository petRepository; // comunica cm bd

	@Autowired
	private PetService petService;

	@Autowired
	private UserRepository userRepository;

	// cadastro de novo pet
	@GetMapping("/novo_pet")
	public String formulario(RequisicaoNovoPet requisicaoPet) {
		return "pet/novo_pet";
	}

	// salva novo pet
	@PostMapping("/novo")
	public String novo(@Valid RequisicaoNovoPet requisicaoPet, BindingResult result) {
		if (result.hasErrors()) {
			return "pet/novo_pet";
		}

		// informar ql é o usuario logado, contextholder
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(username);

		Pet pet = requisicaoPet.toPet(); // padrão pra converter a requisição em um objeto
		pet.setUser(user); // user do bd, vem via repository

		petRepository.save(pet);

		return "redirect:/home";
	}

	// exibe cadastro de atualização
	@GetMapping("/exibirFormForUpdatePets/{id}")
	public String exibirFormForUpdatePets(@PathVariable("id") long id, Model model) {

		Pet pet = petRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Pet inválido para id: " + id));

		model.addAttribute("pet", pet);
		return "pet/pet_atualizado";

	}

	@PostMapping("/atualizarPet/{id}")
	public String atualizarPet(@PathVariable("id") long id, @Valid Pet pet, BindingResult result, Model model) {
		if (result.hasErrors()) {
			pet.setId(id);
			return "pet/pet_atualizado";
		}

		petRepository.save(pet);
		return "pet/index";
	}

	// outra abordagem de CRUD simplificado

	@GetMapping("/pets_cadastrados") // ou o "/"
	public String exibirPets(Model model) {
		model.addAttribute("listaPets", petService.getAllPets());
		return "pet/index"; // ou o index
	}

	@PostMapping("/salvarPet")
	public String salvarPet(@ModelAttribute("pet") Pet pet) {
		petService.savePet(pet);
		return "pet/index";
	}

	@GetMapping("/removerPet/{id}")
	public String removerPet(@PathVariable(value = "id") long id, Model model) {
		Pet pet = petRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Pet inválido para id: " + id));

		petRepository.delete(pet);
		return "pet/index";

	}

}
