package br.com.fatec.ads.es.hopeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatec.ads.es.hopeapi.model.Animal;
import br.com.fatec.ads.es.hopeapi.service.AnimalService;

/**
 * Essa classe é responsável por mapear as ações requisitadas pela view e
 * apresentar as devidas respostas para o Parceiro gerenciar os cadastros
 * 
 * @author xlnst
 *
 */
@Controller
@RequestMapping("/home/animais")
public class AnimalController {

	@Autowired
	private AnimalService animalService;

	@GetMapping
	String home(Model model) {
		model.addAttribute("listaAnimais", animalService.getAllAnimais());
		return "animal/index";
	}

	@GetMapping("/exibirNovoAnimalForm")
	public String exibirNovoAnimalForm(Model model) {
		Animal animal = new Animal();
		model.addAttribute("animal", animal);
		return "animal/novo_animal";

	}

	@PostMapping("/salvarAnimal")
	public String salvarAnimal(@ModelAttribute("animal") Animal animal) {
		animalService.saveAnimal(animal);
		return "redirect:/home/animais";
	}

	@GetMapping("/atualizarAnimal/{id}") // mapeamento da url
	public String atualizarAnimal(@PathVariable(value = "id") long id, Model model) {
		Animal animal = animalService.getAnimalById(id);
		model.addAttribute("animal", animal);

		return "animal/animal_atualizado"; // mapeamento do template
	}

	@GetMapping("/removerAnimal/{id}")
	public String removerAnimal(@PathVariable(value = "id") long id) {
		this.animalService.deleteAnimalById(id);
		return "redirect:/home/animais";
	}

}
